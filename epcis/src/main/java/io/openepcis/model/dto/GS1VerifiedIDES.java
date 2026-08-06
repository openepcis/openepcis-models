/*
 *
 *  * Copyright (c) 2022-2024 benelog GmbH & Co. KG
 *  * All rights reserved.
 *  *
 *  * Unauthorized copying, modification, distribution,
 *  * or use of this work, via any medium, is strictly prohibited.
 *  *
 *  * benelog GmbH & Co. KG reserves all rights not expressly granted herein,
 *  * including the right to sell licenses for using this work.
 *
 */
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.openepcis.model.epcis.modifier.OffsetDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GS1VerifiedIDES {

    private String type;
    private String identifier;
    private String licenseeName;
    private String licenceKey;
    private String licenceType;
    private String licenseeGLN;
    private String licensingMOName;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonFormat(without = {ADJUST_DATES_TO_CONTEXT_TIME_ZONE, WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS})
    private OffsetDateTime createdAt;
}
