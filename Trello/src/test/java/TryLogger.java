import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.core.BrowserFactory;

import org.testng.annotations.Test;

public class TryLogger extends BrowserFactory {

    private Logger logger = LoggerFactory.getLogger(TryLogger.class);

    @Test
    public void asdasd(){
        logger.info("Hello world !!!");
    }
}
