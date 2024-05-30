package at.livekit.api.datapersistors;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.StringType;

import at.livekit.api.core.Color;

public class ColorPersistor extends StringType {
    
    private static ColorPersistor instance;

    public static ColorPersistor getSingleton() {
        if(instance == null) {
            instance = new ColorPersistor();
        }
        return instance;
    }

    private ColorPersistor() {
        super(SqlType.STRING, new Class<?>[]{Color.class});
    }

    @Override
	public Object javaToSqlArg(FieldType fieldType, Object javaObject) {
		Color color = (Color) javaObject;
		if(color == null) return null;
        return color.getHEX();
	}

	@Override
	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) {
		return sqlArg != null ? Color.fromHEX((String)sqlArg) : null;
	}

    
}
