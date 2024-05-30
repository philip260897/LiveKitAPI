package at.livekit.api.datapersistors;

import java.util.UUID;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.StringType;

import at.livekit.api.core.LKLocation;

public class LKLocationPersistor extends StringType {

    private static LKLocationPersistor instance;

    public static LKLocationPersistor getSingleton() {
        if(instance == null) {
            instance = new LKLocationPersistor();
        }
        return instance;
    }

    private LKLocationPersistor() {
        super(SqlType.STRING, new Class<?>[]{LKLocation.class});
    }

    @Override
	public Object javaToSqlArg(FieldType fieldType, Object javaObject) {
		LKLocation location = (LKLocation) javaObject;
		if(location == null) return null;
        
        return location.getWorld()+"["+round(location.getX())+";"+round(location.getY())+";"+round(location.getZ())+"]";
	}

	@Override
	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) {
		if(sqlArg == null) return null;
        
        try{
            String arg = (String)sqlArg;
            String uuid = arg.split("\\[")[0];
            String[] nums = arg.replace(uuid, "").replace("[", "").replace("]", "").split(";");

            double x = Double.parseDouble(nums[0]);
            double y = Double.parseDouble(nums[1]);
            double z = Double.parseDouble(nums[2]);

            return new LKLocation(uuid, x, y, z);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
	}

    private double round(double number) {
        return (double)((int)(number * 100.0)) / 100.0;
    }
}
