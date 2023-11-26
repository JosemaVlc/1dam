import subprocess

try:
    subprocess.run(["ping", "www.google.com", "-n", "2"])
except subprocess.CalledProcessError as e:
    print(e.output)