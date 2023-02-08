package com.personPractice.services;

import com.personPractice.models.Image;

public interface ImageService extends CrudService<Image, Long>{

     String encodeImage(String imagePath);
}
