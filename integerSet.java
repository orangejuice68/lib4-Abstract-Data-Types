import java.util.ArrayList;

import javax.management.RuntimeErrorException;
/** ADT ที่เก็บ Integer เรียงจากน้อยไปมาก 
 * @param <Numbers>
 * 
 */
public class integerSet {
    ArrayList <integerSet> Numbers ; // Rep
    // ห้ามตัวเลขซ้ำ
    // เลขเรียงจากน้อยไปมาก
    // ห้ามเป็น null
    // AF คือ AF(Numbers) numbers คือค่า arr ที่มีค่าเป็น integer
 
    public integerSet(){
        Numbers = new ArrayList<>();
        CheckRep();

    }
}
    private void CheckRep(){
        if(Numbers==null)
            throw new RuntimeException("Numbers");
        if(Numbers.size()>1){  //ต้องค้น2ตัวขึ้นไป
            for(int i = 0 ; i < Numbers.size() - 1 ; i++){
                if(Numbers.get(i) >= Numbers.get(i+1)){
                    throw new RuntimeException("Rep invariant violated");
                }
                 
            }
        }
    }
    /**
     * เพิ่มตัวเลข
     *  @param x คือค่าที่จะเพิ่ม
     */
    public void add(Integer x){
        if(!Numbers.contains(x) && Numbers != null && x != null){
            if(Numbers.size()==0){
                Numbers.add(x);
            }else{
                for(int i=0 ; i<Numbers.size() ; i++){
                    if(x < Numbers.get(0)){ // add ด้านหน้า
                        Numbers.add(0,x);
                        break;
                    }
                    if(i==Numbers.size()-1){ // add หลังสุด
                        Numbers.add(x);
                        break;
                    }
                    if(Numbers.get(i)<x && x<Numbers.get(i+1)){ // add ตรงกลาง
                        Numbers.add(i+1,x); // เป็น i+1 เพราะต้องไปต่อหลัง i
                        break;
                    }
                }
            }
        }
        CheckRep();
    }
    /**
     * ลบข้อมูล
     * @param x
     */
    public void remove(Integer x){
        if(x == null)
         return;
         Numbers.remove(x);
    }
    /**
     * ตรวจสอบว่ามีเลขอยู่ในเซตไหม
     * @return ture ถ้ามี x อยู่ในนั้น , flase ถ้าไม่มี
     */
    public boolean contains(Integer x){
        return Numbers.contains(x);
    }
    /**
     * ขนาดของเซต
     * @return จำนวนสมาชิก
     */
      public int size() {
        return Numbers.size();
    }

    public String toString(){
        return Numbers.toString();
    }
  
   
}
