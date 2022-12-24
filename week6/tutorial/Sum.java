public class Sum {
    void sumOfNaturals(int value){//4n+n
        int sum=0;// 1 operation
        for(int i =1; i <= value; i++){ // 1+(n+1)+n operation
            sum += i;//n operation
        }
        System.out.println(sum); //1 operation
    }

    void demo(int value){
        for(int i =1; i <= value; i=i*2){//1+ n/2+1 + n/2
            System.out.println(i);//n/2 
        }
    }

}
