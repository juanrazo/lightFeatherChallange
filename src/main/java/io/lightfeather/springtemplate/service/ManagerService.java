package io.lightfeather.springtemplate.service;

import io.lightfeather.springtemplate.dto.ManagerResponse;
import io.lightfeather.springtemplate.model.Manager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    private final URL LINK = new URL("https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers");


    public ManagerService() throws MalformedURLException {
    }

    public List<ManagerResponse> getAllManagers() throws IOException {
        try {
            HttpURLConnection connection = (HttpURLConnection) LINK.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw  new RuntimeException("HttpResponseCode: " + responseCode);
            }
            else {
                String inline = "";
                Scanner scanner = new Scanner(LINK.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                JSONParser parser = new JSONParser();
                JSONArray dataObject = (JSONArray) parser.parse(inline);
                List<Manager> managerList = new ArrayList<>();
                for (int i = 0; i < dataObject.size(); i++) {
                    JSONObject object = (JSONObject) dataObject.get(i);
                    if (Character.isLetter(object.get("jurisdiction").toString().charAt(0))) {
                        managerList.add(mapObjectToManager(object));
                    }
                }
                managerList.sort(Manager::compareTo);

                return managerList.stream().map(ManagerResponse::from).collect(Collectors.toList());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    private Manager mapObjectToManager(JSONObject object) {
        Manager manager = new Manager();
        manager.setFirstName((String) object.get("firstName"));
        manager.setLastName((String) object.get("lastName"));
        manager.setJurisdiction(object.get("jurisdiction").toString().charAt(0));
        manager.setPhone((String) object.get("phone"));
        manager.setIdentificationNumber(UUID.fromString((String) object.get("identificationNumber")));
        return manager;
    }
}
