package com.qw.boot.examples.xxljob.jobhandler;

import com.qw.boot.examples.xxljob.entity.FundHistory;
import com.qw.boot.examples.xxljob.service.FundJobService;
import com.qw.boot.examples.xxljob.service.FundJobServiceImpl;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * XxlJob开发示例（Bean模式）
 * <p>
 * 开发步骤：
 * 1、任务开发：在Spring Bean实例中，开发Job方法；
 * 2、注解配置：为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobHelper.log" 打印执行日志；
 * 4、任务结果：默认任务结果为 "成功" 状态，不需要主动设置；如有诉求，比如设置任务结果为失败，可以通过 "XxlJobHelper.handleFail/handleSuccess" 自主设置任务结果；
 *
 * @author xuxueli 2019-12-11 21:52:51
 */
@Component
public class SampleXxlJob {

    private static Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);



    @Autowired
    private FundJobService fundJobService;

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public ReturnT<String> execute(String param) {
        logger.error("====job定时获取基金信息==========基金代码：{}，==========开始=========", param);
        try {
            List<FundHistory> query = fundJobService.findByCode(param);
            query.forEach(fundHistory -> {
                logger.info(fundHistory.toString());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.error("====job定时获取基金信息==========基金代码：{}，==========结束=========", param);
        return ReturnT.SUCCESS;
    }


}
