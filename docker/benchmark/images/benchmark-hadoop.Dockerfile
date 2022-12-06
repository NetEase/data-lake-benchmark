# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
ARG BENCHMARK_VERSION

FROM arctic163/benchmark-base:${BENCHMARK_VERSION}

ARG HADOOP_VERSION


ARG APACHE_MIRROR
ARG MAVEN_MIRROR

ENV HADOOP_HOME=/opt/hadoop
ENV HADOOP_CONF_DIR=/etc/hadoop/conf

RUN set -x && \
    if [ $(uname -m) = "aarch64" ]; then HADOOP_TAR_NAME=hadoop-${HADOOP_VERSION}-aarch64; else HADOOP_TAR_NAME=hadoop-${HADOOP_VERSION}; fi && \
    wget -q ${APACHE_MIRROR}/hadoop/core/hadoop-${HADOOP_VERSION}/${HADOOP_TAR_NAME}.tar.gz && \
    tar -xzf ${HADOOP_TAR_NAME}.tar.gz -C /opt && \
    ln -s /opt/hadoop-${HADOOP_VERSION} ${HADOOP_HOME} && \
    rm ${HADOOP_TAR_NAME}.tar.gz
