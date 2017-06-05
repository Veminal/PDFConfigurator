package net.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataArray;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.configuration.read.ReadDataInt;
import net.veminal.pdf.configuration.read.ReadDataList;
import net.veminal.pdf.configuration.write.WriteConfig;
import net.veminal.pdf.configuration.write.WriteDataSize;
import net.veminal.pdf.core.annotations.ArrayReader;
import net.veminal.pdf.core.annotations.IntReader;
import net.veminal.pdf.core.annotations.ListReader;
import net.veminal.pdf.core.annotations.StringReader;

/**
 * Configuration of dependencies for working with configuration files.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ConfigurationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReadConfig.class).annotatedWith(StringReader.class)
                .to(ReadDataFields.class);
        bind(ReadConfig.class).annotatedWith(ListReader.class)
                .to(ReadDataList.class);
        bind(ReadConfig.class).annotatedWith(ArrayReader.class)
                .to(ReadDataArray.class);
        bind(ReadConfig.class).annotatedWith(IntReader.class)
                .to(ReadDataInt.class);
        bind(WriteConfig.class).to(WriteDataSize.class);
    }
}
