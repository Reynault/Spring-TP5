export const environment = {
  production: false,
  backend: {
    protocol: 'http',
    host: 'localhost',
    port: '9999',
    service: 'album-service',
    endpoints: {
      getAlbums: '/albums',
      deleteAlbum: '/albums/:id',
      postAlbum: '/albums',
      putAlbum: '/albums/:id'
    }
  }
};
