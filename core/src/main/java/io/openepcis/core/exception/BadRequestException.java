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

package io.openepcis.core.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
