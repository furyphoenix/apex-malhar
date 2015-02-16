/*
 *  Copyright (c) 2012-2015 Malhar, Inc.
 *  All Rights Reserved.
 */

package com.datatorrent.lib.appdata.schemas.ads;

import com.datatorrent.lib.appdata.qr.QueryDeserializerFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Timothy Farkas: tim@datatorrent.com
 */
public class AdsUpdateQueryTest
{

  public AdsUpdateQueryTest()
  {
  }

  @Test
  public void testDeserialization()
  {
    final String id = "js34135136425";
    final String type = "updateQuery";
    final String bucket = "1h";
    final String advertiser = "starbucks";
    final String publisher = "google";

    final String json = "{\n" +
                        "   \"id\": \"" + id + "\",\n" +
                        "   \"type\": \"" + type + "\",\n" +
                        "   \"data\": { \n" +
                        "      \"time\": {\n" +
                        "	   \"bucket\": \"" + bucket + "\"\n" +
                        "      },\n" +
                        "      \"keys\": {\n" +
                        "   \"advertiser\": \"" + advertiser + "\",\n" +
                        "   \"publisher\": \"" + publisher + "\" \n" +
                        "      }\n" +
                        "   } \n" +
                        "}";


    @SuppressWarnings("unchecked")
    QueryDeserializerFactory qb = new QueryDeserializerFactory(AdsUpdateQuery.class);

    AdsUpdateQuery aotq = (AdsUpdateQuery) qb.deserialize(json);

    Assert.assertEquals("Ids must match.", id, aotq.getId());
    Assert.assertEquals("Types must match.", type, aotq.getType());
    Assert.assertEquals("Buckets must match.", bucket, aotq.getData().getTime().getBucket());
    Assert.assertEquals("Advertisers must match.", advertiser, aotq.getData().getKeys().getAdvertiser());
    Assert.assertEquals("Publishers must match.", publisher, aotq.getData().getKeys().getPublisher());
  }

}