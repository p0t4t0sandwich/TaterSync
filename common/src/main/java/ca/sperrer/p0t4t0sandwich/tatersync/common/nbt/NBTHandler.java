package ca.sperrer.p0t4t0sandwich.tatersync.common.nbt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.nullicorn.nedit.NBTReader;
import me.nullicorn.nedit.type.NBTCompound;
import net.querz.nbt.io.NBTUtil;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.Tag;

import java.io.File;

public class NBTHandler {
    public static void parseInventoryFromNBT(String player_uuid, String filepath) {
        try {
            String filename = filepath + File.separator + "playerdata" + File.separator + player_uuid + ".dat";
//            NamedTag namedTag = NBTUtil.read(filename);
//            Tag<?> tag = namedTag.getTag();

            NBTCompound result = NBTReader.readFile(new File(filename));

            Gson gson = new GsonBuilder().create();
            String data_json = gson.toJson(result.get("Inventory"));
            System.out.println(data_json);

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
