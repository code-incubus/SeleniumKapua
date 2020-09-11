package commons.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class WatcherRule extends TestWatcher {

    static Logger LOG = LogManager.getLogger(WatcherRule.class);

    @Override
    protected void succeeded(Description description) {
        LOG.error(description.getMethodName() + " -> SUCCEEDED");
    }

    @Override
    protected void failed(Throwable e, Description description) {
        LOG.error(description.getMethodName() +  e + " -> FAILED WITH");
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        LOG.error(description.getMethodName() +  e + " -> SKIPPED");
    }

    @Override
    protected void starting(Description description) {
        LOG.error(description.getMethodName() + " -> IS STARTING...");
    }

    @Override
    protected void finished(Description description) {
        LOG.error(description.getMethodName() +" -> FINISHED");
    }
}
