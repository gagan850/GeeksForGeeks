
public class Fan {

    int OFF = -1;
    int LOW = 1;
    int MED = 2;
    int state;
    
    Fan () {
        
    }
    
    
    public void pullChain() {
        if (this.state == OFF) {
            System.out.println("Turning Fan to Low");
            this.state = LOW;
        
        }
        
        if (this.state == LOW) {
            System.out.println("Turning Fan to Med");
            this.state = MED;
        
        }
        
        if (this.state == MED) {
            System.out.println("Turning off Fan");
            this.state = OFF;
        
        }
    }
    
    
    @Override
    public String toString() {

        if (this.state == OFF) {
            
            System.out.println("Fan Is Off");
            
        }

        if (this.state == OFF) {
            System.out.println("Fan is on LOW");
            
        }
        if (this.state == OFF) {
            System.out.println("Fan is on Med");
            
        }
        return super.toString();
    }
}
