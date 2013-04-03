package com.citytechinc.cq.hooks;

import com.day.jcr.vault.packaging.InstallContext;
import com.day.jcr.vault.packaging.InstallHook;
import com.day.jcr.vault.packaging.PackageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;

public final class ExampleHook implements InstallHook {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleHook.class);

    @Override
    public void execute(final InstallContext installContext) throws PackageException {
        final InstallContext.Phase phase = installContext.getPhase();

        LOG.info("execute() phase = {}", phase.name());

        if (phase.equals(InstallContext.Phase.INSTALLED)) {
            final Session session = installContext.getSession();

            LOG.info("execute() session ID = {}", session.getUserID());
        }
    }
}
