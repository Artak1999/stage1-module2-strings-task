package com.epam.mjc;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature = new MethodSignature("");
        String[] split = signatureString.split("\\R");
        for (int i = 0; i < split.length; i++) {
            String result = "";
            int count = 0;
            for (int j = 0; j < split[i].length(); j++) {
                if(split[i].charAt(j) == ' ')
                    break;
                else {
                    result += split[i].charAt(j);
                    count++;
                }
            }
            if(result.equals("String"))
                result = null;
            methodSignature.setAccessModifier(result);
            result = "";
            for (int j = count+1; j < split[i].length(); j++) {
                if(split[i].charAt(j) == ' ' || split[i].charAt(j) == '(')
                    break;
                else {
                    result += split[i].charAt(j);
                    count++;
                }
            }
            if(result.equals("repeat"))
                result = "String";
            methodSignature.setReturnType(result);
            result = "";
            for (int j = count+2; j < split[i].length(); j++) {
                if(split[i].charAt(j) == ' ' || split[i].charAt(j) == '(')
                    break;
                else {
                    result += split[i].charAt(j);
                }
            }
            if(result.equals("String"))
                result = "repeat";
           methodSignature.setMethodName(result);
        }
        return methodSignature;
    }
}
