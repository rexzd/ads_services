import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd
import os

cols = ["messageCount", "payloadSize", "mode", "timeMs"]
rest  = pd.read_csv("rest_perf.csv",  names=cols);  rest["implementation"]  = "REST"
grpc  = pd.read_csv("grpc_perf.csv",  names=cols);  grpc["implementation"]  = "gRPC"
proto = pd.read_csv("proto_perf.csv", names=cols); proto["implementation"] = "Proto"
df = pd.concat([rest, grpc, proto], ignore_index=True)
df["messageCount"] = df["messageCount"].astype(str)
df["payloadSize"]  = df["payloadSize"].astype(int)
df["timeMs"]       = df["timeMs"].astype(float)

os.makedirs("plots", exist_ok=True)

# Sequential by message count
plt.figure(figsize=(8,6))
sns.boxplot(data=df[df["mode"]=="sequential"], x="messageCount", y="timeMs", hue="implementation", order=sorted(df["messageCount"].unique()))
plt.yscale("log")

plt.title("Sequential retrieval times by message count")
plt.xlabel("Message count (log scale)")
plt.ylabel("Time (ms, log scale)")
plt.tight_layout()
plt.savefig("plots/boxplot_seq_messageCount.png")
plt.close()

# Batch by message count
plt.figure(figsize=(8,6))
sns.boxplot(data=df[df["mode"]=="batch"], x="messageCount", y="timeMs", hue="implementation", order=sorted(df["messageCount"].unique()))
plt.yscale("log")
plt.title("Batch retrieval times by message count")
plt.xlabel("Message count (log scale)")
plt.ylabel("Time (ms, log scale)")
plt.tight_layout()
plt.savefig("plots/boxplot_batch_messageCount.png")
plt.close()

# Sequential by payload size
plt.figure(figsize=(8,6))
sns.boxplot(data=df[df["mode"]=="sequential"], x="payloadSize", y="timeMs", hue="implementation", order=sorted(df["payloadSize"].unique()))
plt.yscale("log")
plt.title("Sequential retrieval times by payload size")
plt.xlabel("Payload size (bytes)")
plt.ylabel("Time (ms, log scale)")
plt.tight_layout()
plt.savefig("plots/boxplot_seq_payloadSize.png")
plt.close()

# Batch by payload size
plt.figure(figsize=(8,6))
sns.boxplot(data=df[df["mode"]=="batch"], x="payloadSize", y="timeMs", hue="implementation", order=sorted(df["payloadSize"].unique()))
plt.yscale("log")
plt.title("Batch retrieval times by payload size")
plt.xlabel("Payload size (bytes)")
plt.ylabel("Time (ms, log scale)")
plt.tight_layout()
plt.savefig("plots/boxplot_batch_payloadSize.png")
plt.close()
