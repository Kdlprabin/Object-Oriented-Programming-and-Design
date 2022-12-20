public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(){
        super("Currently,there are no reports for this tenant!");
    }
}
