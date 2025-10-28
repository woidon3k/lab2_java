import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
        char [] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}; 
        int n = 24;
        int c3 = n % 3;
        int c17 = n % 17;
        System.out.println(c3 + " " + c17);
        StringBuilder str = new StringBuilder("Anton Pasha Dima Bob Hank orange Oval Banana Uber Is Evidens");
        ArrayList<StringBuilder> builders = new ArrayList<StringBuilder>();
        StringBuilder tmp = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                builders.add(tmp);
                tmp = new StringBuilder("");
            }
            else tmp = tmp.append( str.charAt(i));

        }
        ArrayList <StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < builders.size(); i++){
            //if (builders[i].toString().toCharArray()[0]  )
            for (char letter: vowels){
                if (builders.get(i).charAt(0) == letter){
                    result.add(builders.get(i));
                    for (int j = 0; j < result.size() - 1; j++){
                        if (result.get(j).toString().toCharArray()[1] > builders.get(i).toString().toCharArray()[1]){
                            StringBuilder temp = result.get(j);
                            result.add(j, builders.get(i));
                            result.remove(result.size() - 1);
                            result.add(temp);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

}
