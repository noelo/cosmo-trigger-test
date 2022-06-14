package com.noc;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.CosmosDBTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;

public class Function {

    @FunctionName("cosmosDBMonitor")
    public void cosmosDbProcessor(
            @CosmosDBTrigger(name = "items", databaseName = "wcdb", collectionName = "wcdb-container1", leaseCollectionName = "leases", createLeaseCollectionIfNotExists = true, connectionStringSetting = "wcdbcs1") String[] items,
            final ExecutionContext context) {
        context.getLogger().info("cosmosDbProcessor powered by Quarkus");
        context.getLogger().info(items.length + "item(s) is/are changed.");
    }
}
