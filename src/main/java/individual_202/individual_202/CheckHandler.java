package individual_202.individual_202;

public interface CheckHandler {
	public void setNextStep(CheckHandler nextHandler);
	public void check();
}
