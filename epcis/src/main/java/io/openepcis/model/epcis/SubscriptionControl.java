/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionControl", propOrder = {"QuerySchedule", "trigger", "initialRecordTime", "reportIfEmpty"})
public class SubscriptionControl {
  private String QuerySchedule;
  private URI trigger;
  private Date initialRecordTime;
  private Boolean reportIfEmpty;

  public String getQuerySchedule() {
    return this.QuerySchedule;
  }

  public URI getTrigger() {
    return this.trigger;
  }

  public Date getInitialRecordTime() {
    return this.initialRecordTime;
  }

  public Boolean getReportIfEmpty() {
    return this.reportIfEmpty;
  }

  public void setQuerySchedule(String QuerySchedule) {
    this.QuerySchedule = QuerySchedule;
  }

  public void setTrigger(URI trigger) {
    this.trigger = trigger;
  }

  public void setInitialRecordTime(Date initialRecordTime) {
    this.initialRecordTime = initialRecordTime;
  }

  public void setReportIfEmpty(Boolean reportIfEmpty) {
    this.reportIfEmpty = reportIfEmpty;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof SubscriptionControl)) return false;
    SubscriptionControl other = (SubscriptionControl) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$reportIfEmpty = this.getReportIfEmpty();
    Object other$reportIfEmpty = other.getReportIfEmpty();
    if (this$reportIfEmpty == null ? other$reportIfEmpty != null : !this$reportIfEmpty.equals(other$reportIfEmpty)) return false;
    Object this$QuerySchedule = this.getQuerySchedule();
    Object other$QuerySchedule = other.getQuerySchedule();
    if (this$QuerySchedule == null ? other$QuerySchedule != null : !this$QuerySchedule.equals(other$QuerySchedule)) return false;
    Object this$trigger = this.getTrigger();
    Object other$trigger = other.getTrigger();
    if (this$trigger == null ? other$trigger != null : !this$trigger.equals(other$trigger)) return false;
    Object this$initialRecordTime = this.getInitialRecordTime();
    Object other$initialRecordTime = other.getInitialRecordTime();
    if (this$initialRecordTime == null ? other$initialRecordTime != null : !this$initialRecordTime.equals(other$initialRecordTime)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof SubscriptionControl;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $reportIfEmpty = this.getReportIfEmpty();
    result = result * PRIME + ($reportIfEmpty == null ? 43 : $reportIfEmpty.hashCode());
    Object $QuerySchedule = this.getQuerySchedule();
    result = result * PRIME + ($QuerySchedule == null ? 43 : $QuerySchedule.hashCode());
    Object $trigger = this.getTrigger();
    result = result * PRIME + ($trigger == null ? 43 : $trigger.hashCode());
    Object $initialRecordTime = this.getInitialRecordTime();
    result = result * PRIME + ($initialRecordTime == null ? 43 : $initialRecordTime.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "SubscriptionControl(QuerySchedule=" + this.getQuerySchedule() + ", trigger=" + this.getTrigger() + ", initialRecordTime=" + this.getInitialRecordTime() + ", reportIfEmpty=" + this.getReportIfEmpty() + ")";
  }

  public SubscriptionControl() {
  }

  public SubscriptionControl(String QuerySchedule, URI trigger, Date initialRecordTime, Boolean reportIfEmpty) {
    this.QuerySchedule = QuerySchedule;
    this.trigger = trigger;
    this.initialRecordTime = initialRecordTime;
    this.reportIfEmpty = reportIfEmpty;
  }
}
