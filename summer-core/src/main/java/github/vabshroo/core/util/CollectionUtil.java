package github.vabshroo.core.util;

import java.util.Collection;
import java.util.Map;

/**
 * Create by IntelliJ IDEA
 * Collection tools.
 *
 * @Author chenlei
 * @DateTime 2017/10/11 17:51
 * @Description CollectionUtil
 */
public class CollectionUtil {

    /**
     * Return if map contains any key in collection.
     *
     * @param map
     * @param collection
     * @return
     */
    public static boolean containsAnyKey(final Map map, Collection collection){
        if(map == null || collection == null){
            return false;
        }
        for (Object o : collection) {
            if(map.containsKey(o)){
                return true;
            }
        }
        return false;
    }

}
