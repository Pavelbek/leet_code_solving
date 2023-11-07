package pargunov.other.jmagicbobocode;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        var user = loadUserFromDb(123L);
        var userJson = converObjectToJson(user);
//        sendUserJsonToClient(userJson);
    }

    private static void sendUserJsonToClient(String userJson) {
        System.out.println("Sending JSON to a client: ");
        System.out.println(userJson);
    }

    private static String converObjectToJson(Object obj) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        build(obj, sb);
        System.out.println(sb);
        return sb.toString();
    }

    private static String build(Object obj, StringBuilder sb) throws IllegalAccessException {
        sb.append("{\n");
        var fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            var name = f.getName();
            var value = f.get(obj);
            sb.append("\t\"" + name + "\": " );
            if (value instanceof String) {
                sb.append("\"" + value + "\"");
            } else if (value instanceof Number) {
                sb.append(f.get(obj));
            } else {
                build(f.get(obj), sb);
            }

            if (i < fields.length - 1) {
                sb.append(",");
            }

            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    private static User loadUserFromDb(Long id) {
        return new User(id, "Jackson", "Mapper", new Address("Krakow", "Rakowicka"));
    }
}
