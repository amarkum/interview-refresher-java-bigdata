# React JS Notes

## What is node?
It is an extension of JavaScript, and can be run on a machine.

## What is NPM?
NPM is a package manager for Node JS
It can download different modules from existing library.

Run `npm install -g npm` to update!   

## Create ReactJS App
```shell
npx create-react-app my-app
cd my-app
npm start
```

## How to download Modules?
While installing module, we must pas `--save` argument, so that it gets dependency is added to `package.json` <br/>
So, when we run an `npm run build`, the dependency required gets installed.

## What is react Build?
When we run  `npm run build` , the build is group of static file, compressed and minified.
To deploy the code in production, we deploy the code in  `build/` folder.

## What is Netlify?
Netlify is a react app host.
