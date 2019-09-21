public class Main {

    public static void main(String[] args) {

        solve();

    }

    public static void solve(){
        String s="a";
        String answer="";
        String[] sArr=s.split("");
        if (s.length()>1){
            for(int i=0; i<sArr.length-1; i++){
                int cnt=1;

                for(int j=i+1; j<sArr.length; j++){//aabb
                    if(sArr[i].equals(sArr[j])){
                        cnt++;
                        i++;
                        if (j==sArr.length-1){
                            answer+=sArr[i]+String.valueOf(cnt);
                        }
                    }else{
                        answer+=sArr[i]+String.valueOf(cnt);
                        i=j-1;
                        if (j==sArr.length-1){
                            answer+=sArr[j]+"1";
                        }
                        break;
                    }
                }
            }
        } else {
            answer=s+"1";
        }

        if (s.length() < answer.length()){
            System.out.println(s);
        }else{
            System.out.println(answer);
        }
    }


}
