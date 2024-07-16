package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.ImageData;
import tn.esprit.ecommerceespritpi.ResponceMessage.ApiResponse;

import java.util.List;

public interface IImageDataService {
    public ApiResponse<ImageData> saveImageData(ImageData imageData);

    public ApiResponse<List<ImageData>> getAllImagesData();

    public ApiResponse<ImageData> deleteImageData(Long id);

    ApiResponse<List<ImageData>> getAllImagesByProductId(Long productId); // Add this line

}
