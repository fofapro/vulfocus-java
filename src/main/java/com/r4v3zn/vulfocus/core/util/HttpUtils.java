/*
 * Copyright (c) 2019. r4v3zn.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.r4v3zn.vulfocus.core.util;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 * Title: HttpUtils
 * Descrption: HttpUtils
 * Date:2019-06-10 19:10
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class HttpUtils {
    /**
     * private
     */
    private HttpUtils() {
    }

    /**
     * do get
     *
     * @param url requests url
     * @return response info
     */
    public static String doGet(String url) {
        return doGet(url, null);
    }


    /**
     * do post
     *
     * @param actionUrl requests url
     * @param map       requests param
     * @return response info
     */
    public static String doPost(String actionUrl, Map<String, Object> map) {
        String result = "";
        StringBuilder parameterBuilder = new StringBuilder();
        if (map != null && map.size() > 0) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = map.get(key) == null ? "" : map.get(key).toString();
                parameterBuilder.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterBuilder.append("&");
                }
            }
        }
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuilder resultBuilder = new StringBuilder();
        try {

            URL url = new URL(actionUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.toString());
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(parameterBuilder.length()));

            outputStream = connection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(parameterBuilder.toString());
            outputStreamWriter.flush();
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                resultBuilder.append(temp);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception ignored) {
            }
        }
        return resultBuilder.toString();
    }

    /**
     * do get
     *
     * @param actionUrl requests url
     * @param map       requests param
     * @return response info
     */
    public static String doGet(String actionUrl, Map<String, Object> map) {
        String result = "";
        try {
            if (map != null && map.size() > 0) {
                actionUrl += "?";

                StringBuilder actionUrlBuilder = new StringBuilder(actionUrl);
                for (String key : map.keySet()) {
                    actionUrlBuilder.append(key).append("=").append(URLEncoder.encode(map.get(key).toString(), "UTF-8")).append("&");
                }
                actionUrl = actionUrlBuilder.toString();
            }
            URL url = new URL(actionUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = null;
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8));
            }
            StringBuilder s = new StringBuilder();
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                s.append(temp);
            }
            result = s.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
