package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.ecommerceespritpi.Entities.ImageData;
import tn.esprit.ecommerceespritpi.Entities.Product;
import tn.esprit.ecommerceespritpi.Repository.IImageDataRepository;
import tn.esprit.ecommerceespritpi.Repository.IProductRepository;
import tn.esprit.ecommerceespritpi.ResponceMessage.ApiResponse;
import tn.esprit.ecommerceespritpi.Services.IImageDataService;
import tn.esprit.ecommerceespritpi.Util.ImageUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "productsUpload")
public class ImageUploadController {


    @Autowired
    IImageDataRepository imageDataRepository;

    @Autowired
    IImageDataService imageDataService;

    @Autowired
    IProductRepository productRepository;

    @PostMapping(value = "/{productId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ImageData>> uploadImage(@PathVariable("productId") Long productId, @RequestParam("imageFile") MultipartFile file) throws IOException {
        // Retrieve the product by its ID
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(null, "Product not found"));
        }

        Product product = productOptional.get();

        // Create and save the image, associating it with the product
        ImageData img = new ImageData(file.getOriginalFilename(), file.getContentType(), ImageUtil.compressBytes(file.getBytes()));
        img.setProduct(product); // Associate the image with the product
        imageDataRepository.save(img);

        ApiResponse<ImageData> apiResponse = imageDataService.saveImageData(img);

        if (apiResponse.getData() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }
    }

    @GetMapping("/{productId}/images")
    public ResponseEntity<ApiResponse<List<ImageData>>> getAllImagesByProductId(@PathVariable("productId") Long productId) {
        ApiResponse<List<ImageData>> apiResponse = imageDataService.getAllImagesByProductId(productId);

        List<ImageData> imageDataList = new ArrayList<>();
        if (apiResponse.getData() != null) {
            apiResponse.getData().forEach(imageData -> {
                ImageData img = new ImageData(imageData.getId(), imageData.getName(),
                        imageData.getType(), ImageUtil.decompressBytes(imageData.getPicByte()));
                imageDataList.add(img);
            });
            apiResponse.setData(imageDataList);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
        }
    }



    @GetMapping
    @CrossOrigin
    public ApiResponse<List<ImageData>> getAllImages()
    {
        ApiResponse<List<ImageData>> apiResponse = imageDataService.getAllImagesData();

        List<ImageData> imageDataList = new ArrayList<>();

        apiResponse.getData().forEach(imageData -> {
            ImageData img = new ImageData(imageData.getId(), imageData.getName(),
                    imageData.getType(), ImageUtil.decompressBytes(imageData.getPicByte()));
            imageDataList.add(img);
        });

        apiResponse.setData(imageDataList);

        return ResponseEntity.status(apiResponse.getMessage().equals("Image List is fetched") ? HttpStatus.FOUND : HttpStatus.NO_CONTENT).body(apiResponse).getBody();
    }

    @GetMapping(path = { "/get/{imageId}" })
    public ResponseEntity<Optional<ImageData>> getImage(@PathVariable("imageId") int imageId) throws IOException {

        final Optional<ImageData> retrievedImage = imageDataRepository.findById(imageId);

        if(retrievedImage.isPresent())
        {
            ImageData img = new ImageData(retrievedImage.get().getId(), retrievedImage.get().getName(),
                    retrievedImage.get().getType(),
                    ImageUtil.decompressBytes(retrievedImage.get().getPicByte()));
            return ResponseEntity.status(HttpStatus.CREATED).body(Optional.of(img));
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    @DeleteMapping("delete/{productId}")
    public ResponseEntity<ApiResponse<Void>> deleteImage(@PathVariable("productId") Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(null, "Product not found"));
        }

        List<ImageData> images = imageDataRepository.findByProductId(productId);
        if (images.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(null, "No images found for the product"));
        }

        images.forEach(imageDataRepository::delete);

        ApiResponse<Void> apiResponse = new ApiResponse<>(null, "Images deleted successfully");
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
