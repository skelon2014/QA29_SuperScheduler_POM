package schedulerConf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenTestNG implements ITestListener {
    Logger logger = LoggerFactory.getLogger(ListenTestNG.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("[LSTN]: Start succes of test " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ITestListener.super.onTestSuccess(result);
        logger.info("[LSTN] : Start test success --> " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ITestListener.super.onTestFailure(result);
        logger.info("[LSTN] : On failure test --> " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        //screenshots

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
