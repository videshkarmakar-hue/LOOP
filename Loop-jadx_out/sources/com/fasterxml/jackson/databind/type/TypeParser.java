package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes18.dex */
public class TypeParser implements Serializable {
    private static final long serialVersionUID = 1;
    protected final TypeFactory _factory;

    public TypeParser(TypeFactory f) {
        this._factory = f;
    }

    public TypeParser withFactory(TypeFactory f) {
        return f == this._factory ? this : new TypeParser(f);
    }

    public JavaType parse(String canonical) throws IllegalArgumentException {
        MyTokenizer tokens = new MyTokenizer(canonical.trim());
        JavaType type = parseType(tokens);
        if (tokens.hasMoreTokens()) {
            throw _problem(tokens, "Unexpected tokens after complete type");
        }
        return type;
    }

    protected JavaType parseType(MyTokenizer tokens) throws IllegalArgumentException {
        if (!tokens.hasMoreTokens()) {
            throw _problem(tokens, "Unexpected end-of-string");
        }
        Class<?> base = findClass(tokens.nextToken(), tokens);
        if (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if ("<".equals(token)) {
                List<JavaType> parameterTypes = parseTypes(tokens);
                TypeBindings b = TypeBindings.create(base, parameterTypes);
                return this._factory._fromClass(null, base, b);
            }
            tokens.pushBack(token);
        }
        return this._factory._fromClass(null, base, TypeBindings.emptyBindings());
    }

    protected List<JavaType> parseTypes(MyTokenizer tokens) throws IllegalArgumentException {
        ArrayList<JavaType> types = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            types.add(parseType(tokens));
            if (!tokens.hasMoreTokens()) {
                break;
            }
            String token = tokens.nextToken();
            if (">".equals(token)) {
                return types;
            }
            if (!",".equals(token)) {
                throw _problem(tokens, "Unexpected token '" + token + "', expected ',' or '>')");
            }
        }
        throw _problem(tokens, "Unexpected end-of-string");
    }

    protected Class<?> findClass(String className, MyTokenizer tokens) {
        try {
            return this._factory.findClass(className);
        } catch (Exception e) {
            ClassUtil.throwIfRTE(e);
            throw _problem(tokens, "Cannot locate class '" + className + "', problem: " + e.getMessage());
        }
    }

    protected IllegalArgumentException _problem(MyTokenizer tokens, String msg) {
        return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", tokens.getAllInput(), tokens.getRemainingInput(), msg));
    }

    static final class MyTokenizer extends StringTokenizer {
        protected int _index;
        protected final String _input;
        protected String _pushbackToken;

        public MyTokenizer(String str) {
            super(str, "<,>", true);
            this._input = str;
        }

        @Override // java.util.StringTokenizer
        public boolean hasMoreTokens() {
            return this._pushbackToken != null || super.hasMoreTokens();
        }

        @Override // java.util.StringTokenizer
        public String nextToken() {
            if (this._pushbackToken != null) {
                String token = this._pushbackToken;
                this._pushbackToken = null;
                return token;
            }
            String token2 = super.nextToken();
            this._index += token2.length();
            return token2.trim();
        }

        public void pushBack(String token) {
            this._pushbackToken = token;
        }

        public String getAllInput() {
            return this._input;
        }

        public String getRemainingInput() {
            return this._input.substring(this._index);
        }
    }
}
