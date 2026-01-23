# OSRS MCP server (mcp-osrs)

This repo includes a small helper for running the community MCP server from:

- https://github.com/JayArrowz/mcp-osrs

Microbot-Hub itself doesn’t embed an MCP host/client; this is just a convenient place to keep the server wiring/scripts alongside other tooling.

## 1) Prerequisites

- Node.js (LTS recommended)
- npm

## 2) Install the server

Clone the server repo somewhere and install dependencies.

## 3) Register it in your MCP host

Most MCP hosts read a JSON config with a `mcpServers` map.

Example (adjust the `command`, `args`, and working directory to your setup):

```json
{
  "mcpServers": {
    "osrs": {
      "command": "node",
      "args": ["<path-to>/mcp-osrs/dist/index.js"],
      "env": {}
    }
  }
}
```

If your host supports `npx`, you may also be able to use `npx`/`npm` scripts depending on how `mcp-osrs` is packaged.

## 4) Smoke test

Start the MCP host and verify it can list tools from the `osrs` server.
