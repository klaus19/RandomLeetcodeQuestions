package stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String>st = new Stack<>();
        String[]components = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one

        for(String directory:components){

            if(directory.equals(".")||directory.isEmpty()){
                continue;
            }else if(directory.equals("..")){

                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!st.isEmpty()) {
                    st.pop();
                }
            }else{
                // Finally, a legitimate directory name, so we add it
                // to our stack

                st.add(directory);


            }

        }

        //Stich together all the directory names again
        StringBuilder sb = new StringBuilder();
        for(String dir:st){

            sb.append("/");
            sb.append(dir);

        }
        return sb.length() > 0 ? sb.toString():"/";

    }

}
