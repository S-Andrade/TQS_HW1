package com.ua.airQuality.converters;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.air.AirQualityData;

@Converter(autoApply=true)
public class AirQualityDataConverter  implements AttributeConverter<AirQualityData, String>{
    
    @Override
    public String convertToDatabaseColumn(AirQualityData x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<AirQualityData>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public AirQualityData convertToEntityAttribute(String aqdID) {

        if (aqdID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<AirQualityData>(){}.getType();

        return gson.fromJson(aqdID, type);
    }

}
