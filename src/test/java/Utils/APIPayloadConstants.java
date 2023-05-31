package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    // we will pass the body in multiple formats, for this we have created this class


    public static String createEmployeePayLoad() {

        String createEmployeePayload = "{\\n\" +\n" +
                "                        \"    \\\"emp_firstname\\\": \\\"Tam\\\",\\n\" +\n" +
                "                        \"    \\\"emp_lastname\\\": \\\"Shahriar\\\",\\n\" +\n" +
                "                        \"    \\\"emp_middle_name\\\": \\\"I\\\",\\n\" +\n" +
                "                        \"    \\\"emp_gender\\\": \\\"M\\\",\\n\" +\n" +
                "                        \"    \\\"emp_birthday\\\": \\\"1991-03-13\\\",\\n\" +\n" +
                "                        \"    \\\"emp_status\\\": \\\"Confirmed\\\",\\n\" +\n" +
                "                        \"    \\\"emp_job_title\\\": \\\"QA\\\"\\n\" +\n" +
                "                        \"}";

        return createEmployeePayload;

    }

    // dot to string method // change anything to string // conversion

    public static String createEmployeePayLoadJson() {

        JSONObject obj = new JSONObject();

        obj.put("emp_firstname", "Tam");
        obj.put("emp_lastname", "Shahriar");
        obj.put("emp_middle_name", "I");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1991-01-13");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "QA");

        return obj.toString();


    }

    public static String createEmployeePayLoadDynamic(String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender,
                                                      String emp_birthday, String emp_status, String emp_job_title) {

        JSONObject obj = new JSONObject();

        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();

    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();

        obj.put("empployee_id","57579A");
        obj.put("emp_firstname","natalia");
        obj.put("emp_lastname","glusco");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2011-04-22");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Manager");
        return obj.toString();
    }

}
