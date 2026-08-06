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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Schedule {
  private String second;
  private String minute;
  private String hour;
  private String dayOfMonth;
  private String month;
  private String dayOfWeek;

  public Schedule(String cronExpression) {
    final String[] cronAsArray = cronExpression.split(" ");
    this.setSecond(cronAsArray[0]);
    this.setMinute(cronAsArray[1]);
    this.setHour(cronAsArray[2]);
    this.setDayOfMonth(cronAsArray[3]);
    this.setMonth(cronAsArray[4]);
    this.setDayOfWeek(cronAsArray[5]);
  }


  public static class ScheduleBuilder {
    private String second;
    private String minute;
    private String hour;
    private String dayOfMonth;
    private String month;
    private String dayOfWeek;

    ScheduleBuilder() {
    }

    /**
     * @return {@code this}.
     */
    public Schedule.ScheduleBuilder second(String second) {
      this.second = second;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public Schedule.ScheduleBuilder minute(String minute) {
      this.minute = minute;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public Schedule.ScheduleBuilder hour(String hour) {
      this.hour = hour;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public Schedule.ScheduleBuilder dayOfMonth(String dayOfMonth) {
      this.dayOfMonth = dayOfMonth;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public Schedule.ScheduleBuilder month(String month) {
      this.month = month;
      return this;
    }

    /**
     * @return {@code this}.
     */
    public Schedule.ScheduleBuilder dayOfWeek(String dayOfWeek) {
      this.dayOfWeek = dayOfWeek;
      return this;
    }

    public Schedule build() {
      return new Schedule(this.second, this.minute, this.hour, this.dayOfMonth, this.month, this.dayOfWeek);
    }

    @Override
    public String toString() {
      return "Schedule.ScheduleBuilder(second=" + this.second + ", minute=" + this.minute + ", hour=" + this.hour + ", dayOfMonth=" + this.dayOfMonth + ", month=" + this.month + ", dayOfWeek=" + this.dayOfWeek + ")";
    }
  }

  public static Schedule.ScheduleBuilder builder() {
    return new Schedule.ScheduleBuilder();
  }

  public String getSecond() {
    return this.second;
  }

  public String getMinute() {
    return this.minute;
  }

  public String getHour() {
    return this.hour;
  }

  public String getDayOfMonth() {
    return this.dayOfMonth;
  }

  public String getMonth() {
    return this.month;
  }

  public String getDayOfWeek() {
    return this.dayOfWeek;
  }

  public void setSecond(String second) {
    this.second = second;
  }

  public void setMinute(String minute) {
    this.minute = minute;
  }

  public void setHour(String hour) {
    this.hour = hour;
  }

  public void setDayOfMonth(String dayOfMonth) {
    this.dayOfMonth = dayOfMonth;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Schedule)) return false;
    Schedule other = (Schedule) o;
    if (!other.canEqual((Object) this)) return false;
    Object this$second = this.getSecond();
    Object other$second = other.getSecond();
    if (this$second == null ? other$second != null : !this$second.equals(other$second)) return false;
    Object this$minute = this.getMinute();
    Object other$minute = other.getMinute();
    if (this$minute == null ? other$minute != null : !this$minute.equals(other$minute)) return false;
    Object this$hour = this.getHour();
    Object other$hour = other.getHour();
    if (this$hour == null ? other$hour != null : !this$hour.equals(other$hour)) return false;
    Object this$dayOfMonth = this.getDayOfMonth();
    Object other$dayOfMonth = other.getDayOfMonth();
    if (this$dayOfMonth == null ? other$dayOfMonth != null : !this$dayOfMonth.equals(other$dayOfMonth)) return false;
    Object this$month = this.getMonth();
    Object other$month = other.getMonth();
    if (this$month == null ? other$month != null : !this$month.equals(other$month)) return false;
    Object this$dayOfWeek = this.getDayOfWeek();
    Object other$dayOfWeek = other.getDayOfWeek();
    if (this$dayOfWeek == null ? other$dayOfWeek != null : !this$dayOfWeek.equals(other$dayOfWeek)) return false;
    return true;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Schedule;
  }

  @Override
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $second = this.getSecond();
    result = result * PRIME + ($second == null ? 43 : $second.hashCode());
    Object $minute = this.getMinute();
    result = result * PRIME + ($minute == null ? 43 : $minute.hashCode());
    Object $hour = this.getHour();
    result = result * PRIME + ($hour == null ? 43 : $hour.hashCode());
    Object $dayOfMonth = this.getDayOfMonth();
    result = result * PRIME + ($dayOfMonth == null ? 43 : $dayOfMonth.hashCode());
    Object $month = this.getMonth();
    result = result * PRIME + ($month == null ? 43 : $month.hashCode());
    Object $dayOfWeek = this.getDayOfWeek();
    result = result * PRIME + ($dayOfWeek == null ? 43 : $dayOfWeek.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Schedule(second=" + this.getSecond() + ", minute=" + this.getMinute() + ", hour=" + this.getHour() + ", dayOfMonth=" + this.getDayOfMonth() + ", month=" + this.getMonth() + ", dayOfWeek=" + this.getDayOfWeek() + ")";
  }

  public Schedule() {
  }

  public Schedule(String second, String minute, String hour, String dayOfMonth, String month, String dayOfWeek) {
    this.second = second;
    this.minute = minute;
    this.hour = hour;
    this.dayOfMonth = dayOfMonth;
    this.month = month;
    this.dayOfWeek = dayOfWeek;
  }
}
