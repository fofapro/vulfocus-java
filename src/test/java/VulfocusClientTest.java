import com.r4v3zn.vulfocus.core.client.VulfocusClinet;
import com.r4v3zn.vulfocus.core.entity.ImageEntity;

import java.util.List;

/**
 * Title: Vulfocus Client Test
 * Desc: Vulfocus Client
 * Date:2021/11/25 22:24
 * Email:woo0nise@gmail.com
 * Company:www.r4v3zn.com
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class VulfocusClientTest {
    public static void main(String[] args) throws Exception {
        String username = "";
        String license = "";
        VulfocusClinet vulfocusClinet = new VulfocusClinet(username, license);
        List<ImageEntity> imageEntityList = vulfocusClinet.imageList();
        ImageEntity imageEntity = imageEntityList.get(0);
        System.out.println(imageEntity);
        System.out.println(vulfocusClinet.start(imageEntity.getImageName()));
        System.out.println(vulfocusClinet.stop(imageEntity.getImageName()));
        System.out.println(vulfocusClinet.delete(imageEntity.getImageName()));
    }
}
