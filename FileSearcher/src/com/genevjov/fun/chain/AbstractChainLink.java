package com.genevjov.fun.chain;

import java.io.File;
import java.util.Objects;

public abstract class AbstractChainLink {

    private AbstractChainLink nextChainLink;

    public AbstractChainLink linkWithNextElement(AbstractChainLink nextChainLink) {
        Objects.requireNonNull(nextChainLink);
        if (Objects.isNull(this.nextChainLink)) {
            this.nextChainLink = nextChainLink;
        } else {
            return nextChainLink.linkWithNextElement(nextChainLink);
        }
        return nextChainLink;
    }

    public boolean doChain(File file) {
        if (isValid(file)) {
            if (Objects.nonNull(this.nextChainLink)) {
                return this.nextChainLink.doChain(file);
            } else {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean isValid(File file);
}
