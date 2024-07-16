package tn.esprit.ecommerceespritpi.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.ImageData;
import tn.esprit.ecommerceespritpi.Repository.IImageDataRepository;
import tn.esprit.ecommerceespritpi.ResponceMessage.ApiResponse;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ImageDataServiceImpl implements IImageDataService{

    @Autowired
    private IImageDataRepository imageDataRepository;

    @Override
    public ApiResponse<ImageData> saveImageData(ImageData imageData) {

        ApiResponse apiResponse;

        ImageData saveImageData = imageDataRepository.save(imageData);

        apiResponse = new ApiResponse(saveImageData, "Image Uploaded Successfully");
        return apiResponse;

    }

    @Override
    public ApiResponse<List<ImageData>> getAllImagesData() {
        List<ImageData> images = imageDataRepository.findAll();

        log.info("All Images: " , images);
        System.out.println("All images: " +images);

        if(images.isEmpty())
        {
            return new ApiResponse<>(null, "Image List is Empty");
        } else {
            return new ApiResponse<>(images, "Image List is fetched");
        }
    }

    @Override
    public ApiResponse<ImageData> deleteImageData(Long id) {

        Optional<ImageData> itemOptional = imageDataRepository.findById(id);

        ApiResponse apiResponse;

        if(itemOptional.isPresent())
        {
            imageDataRepository.deleteById(id);

            apiResponse = new ApiResponse(itemOptional.get(), "Image successfully deleted");
        } else {
            apiResponse = new ApiResponse(null, "Image Not deleted");
        }

        return apiResponse;
    }

    @Override
    public ApiResponse<List<ImageData>> getAllImagesByProductId(Long productId) {
        List<ImageData> images = imageDataRepository.findByProductId(productId);

        if (images.isEmpty()) {
            return new ApiResponse<>(null, "No images found for the given product ID");
        } else {
            return new ApiResponse<>(images, "Images fetched successfully");
        }
    }


}
