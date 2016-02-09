/**
 * Copyright 2014 Nikita Koksharov, Nickolay Borbit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.redisson.command;

import java.net.InetSocketAddress;
import java.util.List;

import org.redisson.SyncOperation;
import org.redisson.client.codec.Codec;
import org.redisson.client.protocol.RedisCommand;
import org.redisson.connection.ConnectionManager;

import io.netty.util.concurrent.Future;

/**
 *
 * @author Nikita Koksharov
 *
 */
public interface CommandSyncExecutor {

  <V> V get(Future<V> future);

  <T, R> R write(Integer slot, Codec codec, RedisCommand<T> command, Object... params);

  <T, R> R write(String key, Codec codec, RedisCommand<T> command, Object... params);

  <T, R> R write(String key, RedisCommand<T> command, Object... params);

  <T, R> R read(String key, RedisCommand<T> command, Object... params);

  <R> R read(String key, Codec codec, SyncOperation<R> operation);

  <R> R write(String key, Codec codec, SyncOperation<R> operation);

  <T, R> R read(String key, Codec codec, RedisCommand<T> command, Object... params);

  <T, R> R evalRead(String key, RedisCommand<T> evalCommandType, String script, List<Object> keys,
      Object... params);

  <T, R> R evalRead(String key, Codec codec, RedisCommand<T> evalCommandType, String script,
      List<Object> keys, Object... params);

  <T, R> R read(InetSocketAddress client, String key, Codec codec, RedisCommand<T> command,
      Object... params);

  <T, R> R read(InetSocketAddress client, String key, RedisCommand<T> command, Object... params);

  <T, R> R evalWrite(String key, RedisCommand<T> evalCommandType, String script, List<Object> keys,
      Object... params);

  <T, R> R evalWrite(String key, Codec codec, RedisCommand<T> evalCommandType, String script,
      List<Object> keys, Object... params);

  ConnectionManager getConnectionManager();

}
