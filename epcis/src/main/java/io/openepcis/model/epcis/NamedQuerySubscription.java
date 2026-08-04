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
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NamedQuerySubscription {
    private UUID subscriptionID;
    private String wsSessionID;
    private String queryName;
    private String epcisVersion;
    private URI dest;
    private String signatureToken;
    private OffsetDateTime minRecordTime;
    private OffsetDateTime initialRecordTime;
    private Boolean reportIfEmpty;
    private Boolean stream;
    private Schedule schedule;
    private Boolean deleted;
    private OffsetDateTime createdAt;
    private String epcFormat;
    private String cbvFormat;
    private String subscribedBy;
    private String defaultGroup;

    private static Boolean $default$deleted() {
        return false;
    }


    public static class NamedQuerySubscriptionBuilder {
        private UUID subscriptionID;
        private String wsSessionID;
        private String queryName;
        private String epcisVersion;
        private URI dest;
        private String signatureToken;
        private OffsetDateTime minRecordTime;
        private OffsetDateTime initialRecordTime;
        private Boolean reportIfEmpty;
        private Boolean stream;
        private Schedule schedule;
        private boolean deleted$set;
        private Boolean deleted$value;
        private OffsetDateTime createdAt;
        private String epcFormat;
        private String cbvFormat;
        private String subscribedBy;
        private String defaultGroup;

        NamedQuerySubscriptionBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder subscriptionID(UUID subscriptionID) {
            this.subscriptionID = subscriptionID;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder wsSessionID(String wsSessionID) {
            this.wsSessionID = wsSessionID;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder queryName(String queryName) {
            this.queryName = queryName;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder epcisVersion(String epcisVersion) {
            this.epcisVersion = epcisVersion;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder dest(URI dest) {
            this.dest = dest;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder signatureToken(String signatureToken) {
            this.signatureToken = signatureToken;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder minRecordTime(OffsetDateTime minRecordTime) {
            this.minRecordTime = minRecordTime;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder initialRecordTime(OffsetDateTime initialRecordTime) {
            this.initialRecordTime = initialRecordTime;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder reportIfEmpty(Boolean reportIfEmpty) {
            this.reportIfEmpty = reportIfEmpty;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder schedule(Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder deleted(Boolean deleted) {
            this.deleted$value = deleted;
            deleted$set = true;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder epcFormat(String epcFormat) {
            this.epcFormat = epcFormat;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder cbvFormat(String cbvFormat) {
            this.cbvFormat = cbvFormat;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder subscribedBy(String subscribedBy) {
            this.subscribedBy = subscribedBy;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NamedQuerySubscription.NamedQuerySubscriptionBuilder defaultGroup(String defaultGroup) {
            this.defaultGroup = defaultGroup;
            return this;
        }

        public NamedQuerySubscription build() {
            Boolean deleted$value = this.deleted$value;
            if (!this.deleted$set) deleted$value = NamedQuerySubscription.$default$deleted();
            return new NamedQuerySubscription(this.subscriptionID, this.wsSessionID, this.queryName, this.epcisVersion, this.dest, this.signatureToken, this.minRecordTime, this.initialRecordTime, this.reportIfEmpty, this.stream, this.schedule, deleted$value, this.createdAt, this.epcFormat, this.cbvFormat, this.subscribedBy, this.defaultGroup);
        }

        @Override
        public String toString() {
            return "NamedQuerySubscription.NamedQuerySubscriptionBuilder(subscriptionID=" + this.subscriptionID + ", wsSessionID=" + this.wsSessionID + ", queryName=" + this.queryName + ", epcisVersion=" + this.epcisVersion + ", dest=" + this.dest + ", signatureToken=" + this.signatureToken + ", minRecordTime=" + this.minRecordTime + ", initialRecordTime=" + this.initialRecordTime + ", reportIfEmpty=" + this.reportIfEmpty + ", stream=" + this.stream + ", schedule=" + this.schedule + ", deleted$value=" + this.deleted$value + ", createdAt=" + this.createdAt + ", epcFormat=" + this.epcFormat + ", cbvFormat=" + this.cbvFormat + ", subscribedBy=" + this.subscribedBy + ", defaultGroup=" + this.defaultGroup + ")";
        }
    }

    public static NamedQuerySubscription.NamedQuerySubscriptionBuilder builder() {
        return new NamedQuerySubscription.NamedQuerySubscriptionBuilder();
    }

    public UUID getSubscriptionID() {
        return this.subscriptionID;
    }

    public String getWsSessionID() {
        return this.wsSessionID;
    }

    public String getQueryName() {
        return this.queryName;
    }

    public String getEpcisVersion() {
        return this.epcisVersion;
    }

    public URI getDest() {
        return this.dest;
    }

    public String getSignatureToken() {
        return this.signatureToken;
    }

    public OffsetDateTime getMinRecordTime() {
        return this.minRecordTime;
    }

    public OffsetDateTime getInitialRecordTime() {
        return this.initialRecordTime;
    }

    public Boolean getReportIfEmpty() {
        return this.reportIfEmpty;
    }

    public Boolean getStream() {
        return this.stream;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getEpcFormat() {
        return this.epcFormat;
    }

    public String getCbvFormat() {
        return this.cbvFormat;
    }

    public String getSubscribedBy() {
        return this.subscribedBy;
    }

    public String getDefaultGroup() {
        return this.defaultGroup;
    }

    public void setSubscriptionID(UUID subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public void setWsSessionID(String wsSessionID) {
        this.wsSessionID = wsSessionID;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public void setEpcisVersion(String epcisVersion) {
        this.epcisVersion = epcisVersion;
    }

    public void setDest(URI dest) {
        this.dest = dest;
    }

    public void setSignatureToken(String signatureToken) {
        this.signatureToken = signatureToken;
    }

    public void setMinRecordTime(OffsetDateTime minRecordTime) {
        this.minRecordTime = minRecordTime;
    }

    public void setInitialRecordTime(OffsetDateTime initialRecordTime) {
        this.initialRecordTime = initialRecordTime;
    }

    public void setReportIfEmpty(Boolean reportIfEmpty) {
        this.reportIfEmpty = reportIfEmpty;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setEpcFormat(String epcFormat) {
        this.epcFormat = epcFormat;
    }

    public void setCbvFormat(String cbvFormat) {
        this.cbvFormat = cbvFormat;
    }

    public void setSubscribedBy(String subscribedBy) {
        this.subscribedBy = subscribedBy;
    }

    public void setDefaultGroup(String defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof NamedQuerySubscription)) return false;
        NamedQuerySubscription other = (NamedQuerySubscription) o;
        if (!other.canEqual((Object) this)) return false;
        Object this$reportIfEmpty = this.getReportIfEmpty();
        Object other$reportIfEmpty = other.getReportIfEmpty();
        if (this$reportIfEmpty == null ? other$reportIfEmpty != null : !this$reportIfEmpty.equals(other$reportIfEmpty)) return false;
        Object this$stream = this.getStream();
        Object other$stream = other.getStream();
        if (this$stream == null ? other$stream != null : !this$stream.equals(other$stream)) return false;
        Object this$deleted = this.getDeleted();
        Object other$deleted = other.getDeleted();
        if (this$deleted == null ? other$deleted != null : !this$deleted.equals(other$deleted)) return false;
        Object this$subscriptionID = this.getSubscriptionID();
        Object other$subscriptionID = other.getSubscriptionID();
        if (this$subscriptionID == null ? other$subscriptionID != null : !this$subscriptionID.equals(other$subscriptionID)) return false;
        Object this$wsSessionID = this.getWsSessionID();
        Object other$wsSessionID = other.getWsSessionID();
        if (this$wsSessionID == null ? other$wsSessionID != null : !this$wsSessionID.equals(other$wsSessionID)) return false;
        Object this$queryName = this.getQueryName();
        Object other$queryName = other.getQueryName();
        if (this$queryName == null ? other$queryName != null : !this$queryName.equals(other$queryName)) return false;
        Object this$epcisVersion = this.getEpcisVersion();
        Object other$epcisVersion = other.getEpcisVersion();
        if (this$epcisVersion == null ? other$epcisVersion != null : !this$epcisVersion.equals(other$epcisVersion)) return false;
        Object this$dest = this.getDest();
        Object other$dest = other.getDest();
        if (this$dest == null ? other$dest != null : !this$dest.equals(other$dest)) return false;
        Object this$signatureToken = this.getSignatureToken();
        Object other$signatureToken = other.getSignatureToken();
        if (this$signatureToken == null ? other$signatureToken != null : !this$signatureToken.equals(other$signatureToken)) return false;
        Object this$minRecordTime = this.getMinRecordTime();
        Object other$minRecordTime = other.getMinRecordTime();
        if (this$minRecordTime == null ? other$minRecordTime != null : !this$minRecordTime.equals(other$minRecordTime)) return false;
        Object this$initialRecordTime = this.getInitialRecordTime();
        Object other$initialRecordTime = other.getInitialRecordTime();
        if (this$initialRecordTime == null ? other$initialRecordTime != null : !this$initialRecordTime.equals(other$initialRecordTime)) return false;
        Object this$schedule = this.getSchedule();
        Object other$schedule = other.getSchedule();
        if (this$schedule == null ? other$schedule != null : !this$schedule.equals(other$schedule)) return false;
        Object this$createdAt = this.getCreatedAt();
        Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        Object this$epcFormat = this.getEpcFormat();
        Object other$epcFormat = other.getEpcFormat();
        if (this$epcFormat == null ? other$epcFormat != null : !this$epcFormat.equals(other$epcFormat)) return false;
        Object this$cbvFormat = this.getCbvFormat();
        Object other$cbvFormat = other.getCbvFormat();
        if (this$cbvFormat == null ? other$cbvFormat != null : !this$cbvFormat.equals(other$cbvFormat)) return false;
        Object this$subscribedBy = this.getSubscribedBy();
        Object other$subscribedBy = other.getSubscribedBy();
        if (this$subscribedBy == null ? other$subscribedBy != null : !this$subscribedBy.equals(other$subscribedBy)) return false;
        Object this$defaultGroup = this.getDefaultGroup();
        Object other$defaultGroup = other.getDefaultGroup();
        if (this$defaultGroup == null ? other$defaultGroup != null : !this$defaultGroup.equals(other$defaultGroup)) return false;
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof NamedQuerySubscription;
    }

    @Override
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $reportIfEmpty = this.getReportIfEmpty();
        result = result * PRIME + ($reportIfEmpty == null ? 43 : $reportIfEmpty.hashCode());
        Object $stream = this.getStream();
        result = result * PRIME + ($stream == null ? 43 : $stream.hashCode());
        Object $deleted = this.getDeleted();
        result = result * PRIME + ($deleted == null ? 43 : $deleted.hashCode());
        Object $subscriptionID = this.getSubscriptionID();
        result = result * PRIME + ($subscriptionID == null ? 43 : $subscriptionID.hashCode());
        Object $wsSessionID = this.getWsSessionID();
        result = result * PRIME + ($wsSessionID == null ? 43 : $wsSessionID.hashCode());
        Object $queryName = this.getQueryName();
        result = result * PRIME + ($queryName == null ? 43 : $queryName.hashCode());
        Object $epcisVersion = this.getEpcisVersion();
        result = result * PRIME + ($epcisVersion == null ? 43 : $epcisVersion.hashCode());
        Object $dest = this.getDest();
        result = result * PRIME + ($dest == null ? 43 : $dest.hashCode());
        Object $signatureToken = this.getSignatureToken();
        result = result * PRIME + ($signatureToken == null ? 43 : $signatureToken.hashCode());
        Object $minRecordTime = this.getMinRecordTime();
        result = result * PRIME + ($minRecordTime == null ? 43 : $minRecordTime.hashCode());
        Object $initialRecordTime = this.getInitialRecordTime();
        result = result * PRIME + ($initialRecordTime == null ? 43 : $initialRecordTime.hashCode());
        Object $schedule = this.getSchedule();
        result = result * PRIME + ($schedule == null ? 43 : $schedule.hashCode());
        Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        Object $epcFormat = this.getEpcFormat();
        result = result * PRIME + ($epcFormat == null ? 43 : $epcFormat.hashCode());
        Object $cbvFormat = this.getCbvFormat();
        result = result * PRIME + ($cbvFormat == null ? 43 : $cbvFormat.hashCode());
        Object $subscribedBy = this.getSubscribedBy();
        result = result * PRIME + ($subscribedBy == null ? 43 : $subscribedBy.hashCode());
        Object $defaultGroup = this.getDefaultGroup();
        result = result * PRIME + ($defaultGroup == null ? 43 : $defaultGroup.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NamedQuerySubscription(subscriptionID=" + this.getSubscriptionID() + ", wsSessionID=" + this.getWsSessionID() + ", queryName=" + this.getQueryName() + ", epcisVersion=" + this.getEpcisVersion() + ", dest=" + this.getDest() + ", signatureToken=" + this.getSignatureToken() + ", minRecordTime=" + this.getMinRecordTime() + ", initialRecordTime=" + this.getInitialRecordTime() + ", reportIfEmpty=" + this.getReportIfEmpty() + ", stream=" + this.getStream() + ", schedule=" + this.getSchedule() + ", deleted=" + this.getDeleted() + ", createdAt=" + this.getCreatedAt() + ", epcFormat=" + this.getEpcFormat() + ", cbvFormat=" + this.getCbvFormat() + ", subscribedBy=" + this.getSubscribedBy() + ", defaultGroup=" + this.getDefaultGroup() + ")";
    }

    public NamedQuerySubscription() {
        this.deleted = NamedQuerySubscription.$default$deleted();
    }

    public NamedQuerySubscription(UUID subscriptionID, String wsSessionID, String queryName, String epcisVersion, URI dest, String signatureToken, OffsetDateTime minRecordTime, OffsetDateTime initialRecordTime, Boolean reportIfEmpty, Boolean stream, Schedule schedule, Boolean deleted, OffsetDateTime createdAt, String epcFormat, String cbvFormat, String subscribedBy, String defaultGroup) {
        this.subscriptionID = subscriptionID;
        this.wsSessionID = wsSessionID;
        this.queryName = queryName;
        this.epcisVersion = epcisVersion;
        this.dest = dest;
        this.signatureToken = signatureToken;
        this.minRecordTime = minRecordTime;
        this.initialRecordTime = initialRecordTime;
        this.reportIfEmpty = reportIfEmpty;
        this.stream = stream;
        this.schedule = schedule;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.epcFormat = epcFormat;
        this.cbvFormat = cbvFormat;
        this.subscribedBy = subscribedBy;
        this.defaultGroup = defaultGroup;
    }
}
