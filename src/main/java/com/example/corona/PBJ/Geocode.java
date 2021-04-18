package com.example.corona.PBJ;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
public class Geocode {
    public Double[] getResult(String address) throws ParseException {
        //String query = "송파구 잠실동 19";
        String query = address;

        String coordinatex = "127.1054328";
        String coordinatey = "37.3595963";
        String url = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+address+"&coordinate=127.1054328,37.3595963";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        HttpHeaders httpheaders = new HttpHeaders();
        httpheaders.set("X-NCP-APIGW-API-KEY-ID", "3xh2lwk20z");
        httpheaders.set("X-NCP-APIGW-API-KEY", "bb2SaPra87JLSKesbOKf3feWf7CgtM3d53trr9lH");
        httpheaders.set("Accept", "application/json");

        // UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("query","분당구 불정로 6").queryParam("coordinate","127.1054328,37.3595963");

        HttpEntity<String> entity = new HttpEntity<>(httpheaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String s = response.getBody();
        System.out.println(s);


        JSONParser jsonParser = new JSONParser();

        JSONObject body = (JSONObject) jsonParser.parse(response.getBody());

        JSONArray jsonArray = (JSONArray) body.get("addresses");

        JSONObject jsonObj = (JSONObject) jsonArray.get(0);

        String x = (String) jsonObj.get("x");
        String y = (String) jsonObj.get("y");

        Double dx= Double.parseDouble(x);
        Double dy= Double.parseDouble(y);

        Double[] xy = {dy, dx};
        return xy;
    }
}
