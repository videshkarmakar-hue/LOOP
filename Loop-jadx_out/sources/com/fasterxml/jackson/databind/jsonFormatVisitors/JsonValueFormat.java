package com.fasterxml.jackson.databind.jsonFormatVisitors;

import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.fasterxml.jackson.annotation.JsonValue;

/* JADX INFO: loaded from: classes18.dex */
public enum JsonValueFormat {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL(NotificationCompat.CATEGORY_EMAIL),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE(HintConstants.AUTOFILL_HINT_PHONE),
    REGEX("regex"),
    STYLE("style"),
    TIME("time"),
    URI("uri"),
    UTC_MILLISEC("utc-millisec"),
    UUID("uuid");

    private final String _desc;

    JsonValueFormat(String desc) {
        this._desc = desc;
    }

    @Override // java.lang.Enum
    @JsonValue
    public String toString() {
        return this._desc;
    }
}
