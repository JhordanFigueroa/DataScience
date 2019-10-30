import java.util.HashMap;

public class Flight {
    HashMap<String, String> properties = new HashMap<>();

    public Flight(String columnNamesRow,String rowData) {
        String[] columnNames = columnNamesRow.split(",");
        String[] data = rowData.split(",");

        if (columnNames.length == data.length) {
            for(int i = 0; i < columnNames.length; i++) {
                String columnName = columnNames[i];
                String value = data[i];
                properties.put(columnName, value);
            }
        }
    }

    public Integer getNumericalProperty(String key) {
        String property = properties.get(key);
        if (isConvertibleToInteger(property)) {
            return Integer.parseInt(property);
        }
        return null;
    }

    public String getStringProperty(String key) {
        String property = properties.get(key);
        if (property == null || property.equals("")) {
            return null;
        }
        return property;
    }

    public boolean isConvertibleToInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
