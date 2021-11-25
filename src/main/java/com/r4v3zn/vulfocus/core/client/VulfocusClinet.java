package com.r4v3zn.vulfocus.core.client;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r4v3zn.vulfocus.core.constants.OperationConstants;
import com.r4v3zn.vulfocus.core.entity.HostEntity;
import com.r4v3zn.vulfocus.core.entity.ImageEntity;
import com.r4v3zn.vulfocus.core.entity.VulfocusException;
import com.r4v3zn.vulfocus.core.util.HttpUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: VulfocusClinet
 * Desc: Vulfocus for Client
 * Date:2021/11/25 20:30
 * Email:woo0nise@gmail.com
 * Company:www.r4v3zn.com
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class VulfocusClinet {

    /**
     * vulfocus url
     */
    public static String VULFOCUS_URL = "http://vulfocus.io";

    /**
     * api uri
     */
    private static final String VULFOCUS_API_URI = "/api/imgs/operation";

    /**
     * api url
     */
    private static final String VULFOCUS_API_URL = VULFOCUS_URL + VULFOCUS_API_URI;

    /**
     * Jackson mapper
     */
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * username
     */
    private final String username;

    /**
     * licence
     */
    private final String licence;

    /**
     * Vulfocus Clinet
     * @param username username
     * @param licence licence
     */
    public VulfocusClinet(String username, String licence){
        this.username = username;
        this.licence = licence;
    }

    /**
     * Image list
     * @return images
     * @throws Exception exception
     */
    public List<ImageEntity> imageList() throws Exception {
        Map<String,Object> params = new HashMap<>(16);
        params.put("username", this.username);
        params.put("licence", this.licence);
        String response = HttpUtils.doGet(VULFOCUS_API_URL,params);
        JsonNode jsonNode = mapper.readTree(response);
        // check response
        checkResponse(jsonNode);
        String data = jsonNode.get("data").toString();
        List<LinkedHashMap<String,String>> imageEntities = mapper.readValue(data,List.class);
        return imageEntities.stream().map(tmp -> {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageName(tmp.get("image_name"));
            imageEntity.setImageDesc(tmp.get("image_desc"));
            imageEntity.setImageVulName(tmp.get("image_vul_name"));
            return imageEntity;
        }).collect(Collectors.toList());
    }

    /**
     * Start
     * @param imageName image name
     * @return HostEntity
     * @throws Exception exception
     */
    public HostEntity start(String imageName) throws Exception {
        JsonNode dataNode = operation(imageName,OperationConstants.START).get("data");
        HostEntity entity = new HostEntity();
        entity.setHost(dataNode.get("host").asText());
        entity.setPort(dataNode.get("port").asText());
        return entity;
    }

    /**
     * delete
     * @param imageName image name
     * @return response
     * @throws Exception exception
     */
    public String delete(String imageName) throws Exception{
        return operation(imageName,OperationConstants.DELETE).get("msg").asText();
    }

    /**
     * stop
     * @param imageName image name
     * @return response
     * @throws Exception exception
     */
    public String stop(String imageName) throws Exception{
        return operation(imageName,OperationConstants.START).get("msg").asText();
    }


    /**
     * check param
     * @param imageName image name
     * @throws VulfocusException exception
     */
    private void checkParam(String imageName)throws VulfocusException {
        if (imageName == null || "".equals(imageName)){
            throw new VulfocusException("image name cannot be empty");
        }
    }

    /**
     * image operation
     * @param imageName image name
     * @param operation start stop delete
     * @return JsonNode
     * @throws Exception exception
     */
    private JsonNode operation(String imageName, String operation) throws Exception {
        // check param
        checkParam(imageName);
        Map<String,Object> params = new HashMap<>(16);
        params.put("username", this.username);
        params.put("licence", this.licence);
        params.put("image_name", imageName);
        params.put("requisition", operation);
        String response = HttpUtils.doPost(VULFOCUS_API_URL,params);
        JsonNode jsonNode = mapper.readTree(response);
        // check response
        checkResponse(jsonNode);
        return jsonNode;
    }

    /**
     * Check response
     * @param jsonNode json node
     * @throws VulfocusException exception
     */
    private void checkResponse(JsonNode jsonNode)throws VulfocusException{
        String msg =jsonNode.get("msg").asText();
        int status = jsonNode.get("status").asInt();
        if (status != 200){
            throw new VulfocusException(msg);
        }
    }
}
