/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiHackerEarth.com.hackerearth.heapi.sdk.responses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
/**
 *
 * @author Amal
 */
public class RunStatus {
     @Expose
    private String status;
    @SerializedName("time_used")
    @Expose
    private String timeUsed;
    @SerializedName("memory_used")
    @Expose
    private String memoryUsed;
    @Expose
    private String output;
    @SerializedName("output_html")
    @Expose
    private String outputHtml;
    @Expose
    private String signal;
    @SerializedName("status_detail")
    @Expose
    private String statusDetail;
    @SerializedName("time_limit")
    @Expose
    private Integer timeLimit;
    @SerializedName("memory_limit")
    @Expose
    private Integer memoryLimit;

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The timeUsed
     */
    public String getTimeUsed() {
        return timeUsed;
    }

    /**
     *
     * @param timeUsed
     * The time_used
     */
    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed;
    }

    /**
     *
     * @return
     * The memoryUsed
     */
    public String getMemoryUsed() {
        return memoryUsed;
    }

    /**
     *
     * @param memoryUsed
     * The memory_used
     */
    public void setMemoryUsed(String memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    /**
     *
     * @return
     * The output
     */
    public String getOutput() {
        return output;
    }

    /**
     *
     * @param output
     * The output
     */
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     *
     * @return
     * The outputHtml
     */
    public String getOutputHtml() {
        return outputHtml;
    }

    /**
     *
     * @param outputHtml
     * The output_html
     */
    public void setOutputHtml(String outputHtml) {
        this.outputHtml = outputHtml;
    }

    /**
     *
     * @return
     * The signal
     */
    public String getSignal() {
        return signal;
    }

    /**
     *
     * @param signal
     * The signal
     */
    public void setSignal(String signal) {
        this.signal = signal;
    }

    /**
     *
     * @return
     * The statusDetail
     */
    public String getStatusDetail() {
        return statusDetail;
    }

    /**
     *
     * @param statusDetail
     * The status_detail
     */
    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    /**
     *
     * @return
     * The timeLimit
     */
    public Integer getTimeLimit() {
        return timeLimit;
    }

    /**
     *
     * @param timeLimit
     * The time_limit
     */
    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    /**
     *
     * @return
     * The memoryLimit
     */
    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    /**
     *
     * @param memoryLimit
     * The memory_limit
     */
    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }
}
