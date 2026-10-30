package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

/* JADX INFO: compiled from: JsonNodeDeserializer.java */
/* JADX INFO: loaded from: classes18.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    protected final Boolean _supportsUpdates;

    public BaseNodeDeserializer(Class<T> vc, Boolean supportsUpdates) {
        super((Class<?>) vc);
        this._supportsUpdates = supportsUpdates;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig config) {
        return this._supportsUpdates;
    }

    protected void _handleDuplicateField(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory, String fieldName, ObjectNode objectNode, JsonNode oldValue, JsonNode newValue) throws JsonProcessingException {
        if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            ctxt.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", fieldName);
        }
    }

    protected final ObjectNode deserializeObject(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonToken t;
        JsonNode value;
        ObjectNode node = nodeFactory.objectNode();
        String key = p.nextFieldName();
        while (key != null) {
            JsonToken t2 = p.nextToken();
            if (t2 != null) {
                t = t2;
            } else {
                t = JsonToken.NOT_AVAILABLE;
            }
            switch (t.m80id()) {
                case 1:
                    JsonNode value2 = deserializeObject(p, ctxt, nodeFactory);
                    value = value2;
                    break;
                case 2:
                case 4:
                case 5:
                case 8:
                default:
                    value = deserializeAny(p, ctxt, nodeFactory);
                    break;
                case 3:
                    JsonNode value3 = deserializeArray(p, ctxt, nodeFactory);
                    value = value3;
                    break;
                case 6:
                    JsonNode value4 = nodeFactory.textNode(p.getText());
                    value = value4;
                    break;
                case 7:
                    JsonNode value5 = _fromInt(p, ctxt, nodeFactory);
                    value = value5;
                    break;
                case 9:
                    JsonNode value6 = nodeFactory.booleanNode(true);
                    value = value6;
                    break;
                case 10:
                    JsonNode value7 = nodeFactory.booleanNode(false);
                    value = value7;
                    break;
                case 11:
                    JsonNode value8 = nodeFactory.nullNode();
                    value = value8;
                    break;
                case 12:
                    JsonNode value9 = _fromEmbedded(p, ctxt, nodeFactory);
                    value = value9;
                    break;
            }
            JsonNode old = node.replace(key, value);
            if (old != null) {
                _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
            }
            key = p.nextFieldName();
        }
        return node;
    }

    protected final ObjectNode deserializeObjectAtName(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonToken t;
        JsonNode value;
        ObjectNode node = nodeFactory.objectNode();
        String key = p.getCurrentName();
        while (key != null) {
            JsonToken t2 = p.nextToken();
            if (t2 != null) {
                t = t2;
            } else {
                t = JsonToken.NOT_AVAILABLE;
            }
            switch (t.m80id()) {
                case 1:
                    JsonNode value2 = deserializeObject(p, ctxt, nodeFactory);
                    value = value2;
                    break;
                case 2:
                case 4:
                case 5:
                case 8:
                default:
                    value = deserializeAny(p, ctxt, nodeFactory);
                    break;
                case 3:
                    JsonNode value3 = deserializeArray(p, ctxt, nodeFactory);
                    value = value3;
                    break;
                case 6:
                    JsonNode value4 = nodeFactory.textNode(p.getText());
                    value = value4;
                    break;
                case 7:
                    JsonNode value5 = _fromInt(p, ctxt, nodeFactory);
                    value = value5;
                    break;
                case 9:
                    JsonNode value6 = nodeFactory.booleanNode(true);
                    value = value6;
                    break;
                case 10:
                    JsonNode value7 = nodeFactory.booleanNode(false);
                    value = value7;
                    break;
                case 11:
                    JsonNode value8 = nodeFactory.nullNode();
                    value = value8;
                    break;
                case 12:
                    JsonNode value9 = _fromEmbedded(p, ctxt, nodeFactory);
                    value = value9;
                    break;
            }
            JsonNode old = node.replace(key, value);
            if (old != null) {
                _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
            }
            key = p.nextFieldName();
        }
        return node;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:31:0x007c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0083  */
    /* JADX WARN: Code duplicated, block: B:33:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x009a  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ba  */
    protected final JsonNode updateObject(JsonParser p, DeserializationContext ctxt, ObjectNode node) throws IOException {
        String key;
        JsonToken t;
        JsonNodeFactory nodeFactory;
        JsonNode value;
        JsonNode value2;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else {
            if (!p.hasToken(JsonToken.FIELD_NAME)) {
                return deserialize(p, ctxt);
            }
            key = p.getCurrentName();
        }
        while (key != null) {
            JsonToken t2 = p.nextToken();
            JsonNode old = node.get(key);
            if (old != null) {
                if (old instanceof ObjectNode) {
                    JsonNode newValue = updateObject(p, ctxt, (ObjectNode) old);
                    if (newValue != old) {
                        node.set(key, newValue);
                    }
                } else if (old instanceof ArrayNode) {
                    JsonNode newValue2 = updateArray(p, ctxt, (ArrayNode) old);
                    if (newValue2 != old) {
                        node.set(key, newValue2);
                    }
                } else {
                    if (t2 == null) {
                        t = t2;
                    } else {
                        t = JsonToken.NOT_AVAILABLE;
                    }
                    nodeFactory = ctxt.getNodeFactory();
                    switch (t.m80id()) {
                        case 1:
                            JsonNode value3 = deserializeObject(p, ctxt, nodeFactory);
                            value = value3;
                            break;
                        case 2:
                        case 4:
                        case 5:
                        case 8:
                        default:
                            value = deserializeAny(p, ctxt, nodeFactory);
                            break;
                        case 3:
                            JsonNode value4 = deserializeArray(p, ctxt, nodeFactory);
                            value = value4;
                            break;
                        case 6:
                            JsonNode value5 = nodeFactory.textNode(p.getText());
                            value = value5;
                            break;
                        case 7:
                            JsonNode value6 = _fromInt(p, ctxt, nodeFactory);
                            value = value6;
                            break;
                        case 9:
                            JsonNode value7 = nodeFactory.booleanNode(true);
                            value = value7;
                            break;
                        case 10:
                            JsonNode value8 = nodeFactory.booleanNode(false);
                            value = value8;
                            break;
                        case 11:
                            JsonNode value9 = nodeFactory.nullNode();
                            value = value9;
                            break;
                        case 12:
                            JsonNode value10 = _fromEmbedded(p, ctxt, nodeFactory);
                            value = value10;
                            break;
                    }
                    if (old != null) {
                        value2 = value;
                    } else {
                        value2 = value;
                        _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value2);
                    }
                    node.set(key, value2);
                }
            } else {
                if (t2 == null) {
                    t = t2;
                } else {
                    t = JsonToken.NOT_AVAILABLE;
                }
                nodeFactory = ctxt.getNodeFactory();
                switch (t.m80id()) {
                    case 1:
                        JsonNode value11 = deserializeObject(p, ctxt, nodeFactory);
                        value = value11;
                        break;
                    case 2:
                    case 4:
                    case 5:
                    case 8:
                    default:
                        value = deserializeAny(p, ctxt, nodeFactory);
                        break;
                    case 3:
                        JsonNode value12 = deserializeArray(p, ctxt, nodeFactory);
                        value = value12;
                        break;
                    case 6:
                        JsonNode value13 = nodeFactory.textNode(p.getText());
                        value = value13;
                        break;
                    case 7:
                        JsonNode value14 = _fromInt(p, ctxt, nodeFactory);
                        value = value14;
                        break;
                    case 9:
                        JsonNode value15 = nodeFactory.booleanNode(true);
                        value = value15;
                        break;
                    case 10:
                        JsonNode value16 = nodeFactory.booleanNode(false);
                        value = value16;
                        break;
                    case 11:
                        JsonNode value17 = nodeFactory.nullNode();
                        value = value17;
                        break;
                    case 12:
                        JsonNode value18 = _fromEmbedded(p, ctxt, nodeFactory);
                        value = value18;
                        break;
                }
                if (old != null) {
                    value2 = value;
                } else {
                    value2 = value;
                    _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value2);
                }
                node.set(key, value2);
            }
            key = p.nextFieldName();
        }
        return node;
    }

    protected final ArrayNode deserializeArray(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        ArrayNode node = nodeFactory.arrayNode();
        while (true) {
            JsonToken t = p.nextToken();
            switch (t.m80id()) {
                case 1:
                    node.add(deserializeObject(p, ctxt, nodeFactory));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    node.add(deserializeAny(p, ctxt, nodeFactory));
                    break;
                case 3:
                    node.add(deserializeArray(p, ctxt, nodeFactory));
                    break;
                case 4:
                    return node;
                case 6:
                    node.add(nodeFactory.textNode(p.getText()));
                    break;
                case 7:
                    node.add(_fromInt(p, ctxt, nodeFactory));
                    break;
                case 9:
                    node.add(nodeFactory.booleanNode(true));
                    break;
                case 10:
                    node.add(nodeFactory.booleanNode(false));
                    break;
                case 11:
                    node.add(nodeFactory.nullNode());
                    break;
                case 12:
                    node.add(_fromEmbedded(p, ctxt, nodeFactory));
                    break;
            }
        }
    }

    protected final JsonNode updateArray(JsonParser p, DeserializationContext ctxt, ArrayNode node) throws IOException {
        JsonNodeFactory nodeFactory = ctxt.getNodeFactory();
        while (true) {
            JsonToken t = p.nextToken();
            switch (t.m80id()) {
                case 1:
                    node.add(deserializeObject(p, ctxt, nodeFactory));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    node.add(deserializeAny(p, ctxt, nodeFactory));
                    break;
                case 3:
                    node.add(deserializeArray(p, ctxt, nodeFactory));
                    break;
                case 4:
                    return node;
                case 6:
                    node.add(nodeFactory.textNode(p.getText()));
                    break;
                case 7:
                    node.add(_fromInt(p, ctxt, nodeFactory));
                    break;
                case 9:
                    node.add(nodeFactory.booleanNode(true));
                    break;
                case 10:
                    node.add(nodeFactory.booleanNode(false));
                    break;
                case 11:
                    node.add(nodeFactory.nullNode());
                    break;
                case 12:
                    node.add(_fromEmbedded(p, ctxt, nodeFactory));
                    break;
            }
        }
    }

    protected final JsonNode deserializeAny(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        switch (p.currentTokenId()) {
            case 2:
                return nodeFactory.objectNode();
            case 3:
            case 4:
            default:
                return (JsonNode) ctxt.handleUnexpectedToken(handledType(), p);
            case 5:
                return deserializeObjectAtName(p, ctxt, nodeFactory);
            case 6:
                return nodeFactory.textNode(p.getText());
            case 7:
                return _fromInt(p, ctxt, nodeFactory);
            case 8:
                return _fromFloat(p, ctxt, nodeFactory);
            case 9:
                return nodeFactory.booleanNode(true);
            case 10:
                return nodeFactory.booleanNode(false);
            case 11:
                return nodeFactory.nullNode();
            case 12:
                return _fromEmbedded(p, ctxt, nodeFactory);
        }
    }

    protected final JsonNode _fromInt(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonParser.NumberType nt;
        int feats = ctxt.getDeserializationFeatures();
        if ((F_MASK_INT_COERCIONS & feats) != 0) {
            if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats)) {
                nt = JsonParser.NumberType.BIG_INTEGER;
            } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
                nt = JsonParser.NumberType.LONG;
            } else {
                nt = p.getNumberType();
            }
        } else {
            nt = p.getNumberType();
        }
        if (nt == JsonParser.NumberType.INT) {
            return nodeFactory.numberNode(p.getIntValue());
        }
        if (nt == JsonParser.NumberType.LONG) {
            return nodeFactory.numberNode(p.getLongValue());
        }
        return nodeFactory.numberNode(p.getBigIntegerValue());
    }

    protected final JsonNode _fromFloat(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonParser.NumberType nt = p.getNumberType();
        if (nt == JsonParser.NumberType.BIG_DECIMAL) {
            return nodeFactory.numberNode(p.getDecimalValue());
        }
        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (p.isNaN()) {
                return nodeFactory.numberNode(p.getDoubleValue());
            }
            return nodeFactory.numberNode(p.getDecimalValue());
        }
        if (nt == JsonParser.NumberType.FLOAT) {
            return nodeFactory.numberNode(p.getFloatValue());
        }
        return nodeFactory.numberNode(p.getDoubleValue());
    }

    protected final JsonNode _fromEmbedded(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        Object ob = p.getEmbeddedObject();
        if (ob == null) {
            return nodeFactory.nullNode();
        }
        Class<?> type = ob.getClass();
        if (type == byte[].class) {
            return nodeFactory.binaryNode((byte[]) ob);
        }
        if (ob instanceof RawValue) {
            return nodeFactory.rawValueNode((RawValue) ob);
        }
        if (ob instanceof JsonNode) {
            return (JsonNode) ob;
        }
        return nodeFactory.pojoNode(ob);
    }
}
