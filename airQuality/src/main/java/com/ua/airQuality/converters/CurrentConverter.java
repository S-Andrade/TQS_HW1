
package com.ua.airQuality.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.ua.airQuality.models.air.Current;

@Converter(autoApply=true)
public class CurrentConverter  implements AttributeConverter<Current, String>{
    
    @Override
    public String convertToDatabaseColumn(Current x) {

        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Current>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public Current convertToEntityAttribute(String currentID) {

        if (currentID == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<Current>(){}.getType();

        return gson.fromJson(currentID, type);
    }

}
