import com.javamex.classmexer.MemoryUtil;
import com.lufthansa.rmcockpit.service.cache.impl.FlightNumberCache;

class abc {
 
    public static void main(String s[]) {
   
        System.out.println(MemoryUtil.memoryUsageOf(FlightNumberCache.getInstance().getFlightNumberRecords()));
        System.out.println(MemoryUtil.deepMemoryUsageOf(FlightNumberCache.getInstance().getFlightNumberRecords()));

    }
}