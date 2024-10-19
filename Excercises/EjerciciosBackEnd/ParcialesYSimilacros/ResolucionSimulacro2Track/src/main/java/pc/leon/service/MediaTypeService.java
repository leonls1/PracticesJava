package pc.leon.service;

import pc.leon.entitites.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MediaTypeService {
    private Map<String, MediaType> mediaTypeMap;

    public MediaTypeService(){
        this.mediaTypeMap = new HashMap<>();
    }

    public MediaType getOrCreate(String mediaTypeName){
        return mediaTypeMap.computeIfAbsent(mediaTypeName, MediaType:: new);
    }
}
