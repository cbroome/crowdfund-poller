(window.webpackJsonp=window.webpackJsonp||[]).push([[5],{147:function(t,e,a){"use strict";a.r(e);var i=a(0),n=a.n(i),r=(a(148),a(154)),s=(a(165),a(166),a(152),a(7)),o=a.n(s),c=function(t){function e(){var e;return(e=t.call(this)||this).initialize(),e}return o()(e,t),e.prototype.initialize=function(){},e}(n.a.Component),l=(a(167),function(){function t(t){this.initialize(t)}return t.prototype.initialize=function(t){},t}()),d=function(t){function e(){return t.apply(this,arguments)||this}o()(e,t);var a=e.prototype;return a.initialize=function(t){this.summary=t.summary,this.url=t.url,this.description=t.description,t.images.length>0&&(this.image=t.images.pop().url),this.storeAdditionalData(t)},a.storeAdditionalData=function(t){},e}(l),u=function(t){function e(){return t.apply(this,arguments)||this}return o()(e,t),e}(d),f=function(t){function e(){return t.apply(this,arguments)||this}return o()(e,t),e.prototype.storeAdditionalData=function(t){this.schoolName=t.schoolName,this.schoolUrl=t.schoolUrl},e}(d),p=function(t){function e(){return t.apply(this,arguments)||this}o()(e,t);var a=e.prototype;return a.createCampaign=function(t){var e={donorschoose:f,kiva:u}[t.campaign.campaignType.name];if(!e)throw"Could not determine campaign class from "+t.campaignType.name;return new e(t.campaign)},a.storeCampaignResponse=function(t,e){var a=t.pop();e(this.createCampaign(a))},a.fetchCampaign=function(t){var e=this;fetch("http://localhost:8080/campaign/random").then(function(t){return t.json()}).then(function(a){e.storeCampaignResponse(a,t)})},e}(l),h=function(t){function e(){return t.apply(this,arguments)||this}o()(e,t);var a=e.prototype;return a.initialize=function(){this.state={summary:"",description:"",url:"",image:""},this.fetchCampaign()},a.fetchCampaign=function(){(new p).fetchCampaign(this.updateCampaignSettings.bind(this))},a.updateCampaignSettings=function(t){this.setState({url:t.url,description:t.description,summary:t.summary,image:t.image})},a.render=function(){return n.a.createElement("div",{className:"campaign"},n.a.createElement("div",null,n.a.createElement("img",{src:this.state.image,alt:this.state.summary})),n.a.createElement("div",{className:"summary"},this.state.summary),n.a.createElement("div",{className:"description"},this.state.description),n.a.createElement("div",{className:"url"},n.a.createElement("a",{href:"{this.state.url}",target:"_blank"},this.state.url)))},e}(c),m=function(t){function e(){return t.apply(this,arguments)||this}return o()(e,t),e.prototype.render=function(){return n.a.createElement("div",null,n.a.createElement(h,null))},e}(c);e.default=function(){return n.a.createElement(r.a,null,n.a.createElement("h1",null,"Random Active Campaign"),n.a.createElement(m,null))}},148:function(t,e,a){"use strict";a.d(e,"b",function(){return d});var i=a(0),n=a.n(i),r=a(4),s=a.n(r),o=a(33),c=a.n(o);a.d(e,"a",function(){return c.a});a(149);var l=n.a.createContext({}),d=function(t){return n.a.createElement(l.Consumer,null,function(e){return t.data||e[t.query]&&e[t.query].data?(t.render||t.children)(t.data?t.data.data:e[t.query].data):n.a.createElement("div",null,"Loading (StaticQuery)")})};d.propTypes={data:s.a.object,query:s.a.string.isRequired,render:s.a.func,children:s.a.func}},149:function(t,e,a){var i;t.exports=(i=a(151))&&i.default||i},150:function(t){t.exports={data:{site:{siteMetadata:{title:"Gatsby Default Starter"}}}}},151:function(t,e,a){"use strict";a.r(e);a(34);var i=a(0),n=a.n(i),r=a(4),s=a.n(r),o=a(55),c=a(2),l=function(t){var e=t.location,a=c.default.getResourcesForPathnameSync(e.pathname);return n.a.createElement(o.a,Object.assign({location:e,pageResources:a},a.json))};l.propTypes={location:s.a.shape({pathname:s.a.string.isRequired}).isRequired},e.default=l},152:function(t,e,a){"use strict";var i=a(153),n=a(0),r=a.n(n),s=a(4),o=a.n(s),c=a(156),l=a.n(c);function d(t){var e=t.description,a=t.lang,n=t.meta,s=t.keywords,o=t.title,c=i.data.site,d=e||c.siteMetadata.description;return r.a.createElement(l.a,{htmlAttributes:{lang:a},title:o,titleTemplate:"%s | "+c.siteMetadata.title,meta:[{name:"description",content:d},{property:"og:title",content:o},{property:"og:description",content:d},{property:"og:type",content:"website"},{name:"twitter:card",content:"summary"},{name:"twitter:creator",content:c.siteMetadata.author},{name:"twitter:title",content:o},{name:"twitter:description",content:d}].concat(s.length>0?{name:"keywords",content:s.join(", ")}:[]).concat(n)})}d.defaultProps={lang:"en",meta:[],keywords:[],description:""},d.propTypes={description:o.a.string,lang:o.a.string,meta:o.a.arrayOf(o.a.object),keywords:o.a.arrayOf(o.a.string),title:o.a.string.isRequired},e.a=d},153:function(t){t.exports={data:{site:{siteMetadata:{title:"Gatsby Default Starter",description:"Kick off your next, great Gatsby project with this default starter. This barebones starter ships with the main Gatsby configuration files you might need.",author:"@gatsbyjs"}}}}},154:function(t,e,a){"use strict";var i=a(150),n=a(0),r=a.n(n),s=a(4),o=a.n(s),c=a(148),l=function(t){var e=t.siteTitle;return r.a.createElement("header",{style:{background:"rebeccapurple",marginBottom:"1.45rem"}},r.a.createElement("div",{style:{margin:"0 auto",maxWidth:960,padding:"1.45rem 1.0875rem"}},r.a.createElement("h1",{style:{margin:0}},r.a.createElement(c.a,{to:"/",style:{color:"white",textDecoration:"none"}},e))))};l.propTypes={siteTitle:o.a.string},l.defaultProps={siteTitle:""};var d=l,u=(a(155),function(t){var e=t.children;return r.a.createElement(c.b,{query:"755544856",render:function(t){return r.a.createElement(r.a.Fragment,null,r.a.createElement(d,{siteTitle:t.site.siteMetadata.title}),r.a.createElement("div",{style:{margin:"0 auto",maxWidth:960,padding:"0px 1.0875rem 1.45rem",paddingTop:0}},r.a.createElement("main",null,e),r.a.createElement("footer",null,"© ",(new Date).getFullYear(),", Built with"," ",r.a.createElement("a",{href:"https://www.gatsbyjs.org"},"Gatsby"))))},data:i})});u.propTypes={children:o.a.node.isRequired};e.a=u},165:function(t){t.exports={data:{placeholderImage:{childImageSharp:{fluid:{base64:"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAIAAAAC64paAAAACXBIWXMAAAsSAAALEgHS3X78AAACYklEQVQ4y42Uy28SQRjA+dM8efDmwYN6qF6qiSY+Y/WgQRMibY00TaWNBSRSCraYQtHl/bR0KyxQWCgWWAqU8izl/Sq7rLNsRHlVJpvJtzPfb77nDIOcZHSoqZSrp4+KtXIziubaLRysMCZiCYqOoVnhjNEi8RcztdxxeTzc6VBfT+5O2Vhpb+vw4wMdZ0ppWvP9xzLeJoDNThf2W+Nz1+XzNxQubSToSKKW+BDc+WOnkshhSVgeCiGpViZMEg1oxc26Knt+ae3bEtJTZwzE1kXLccG0+sOOlrcvZXvsczPkITfsa20vwIKnhsh+BnjUarT74Gb13CY7KBVJMv3z4N1NszQYsMWM62HNrCis/GxXn0iYls23uz5LPBcv0bH8hUH2XRoM85ySXv7JBtO87jMIvWq+H5GoYIHCLA1ZxD6Qap3Ak8IKfW7TJ50lK6uP9E6RgndHaODtCJ6Z5RyHfnE7j6gRbcKlCYNSt+rtETHTpUGgEP8FYmdNqd/Mo7aiVWTfuH2L9xASvfxxlqr01EYkrJszvNkgW9bH0OuFr+99m+y9IOeyU6zIp/Hubp/yMEztlzFPwOhdvq+nIoS1JNn4t2sugCmVsDvPe2KKolnZLCxhOcAKQRDDXTQaVi46lqYhIBwHTrl3oWqhMRDtaJge37lOBMKo4tfbqhVX0J7snTsWps8uZWuoOQY6CcjpSIF55UvmqNgr5wUwtV1IVdnXtnSfPEB2qjDNqnvczRl0m+j6Jn5lXb6nAQJqinmN0ZEBj03YLzghY8PnTRz80o/GRJZpOLCb0PM9BN7pvUEjx28V00WUg9jIVwAAAABJRU5ErkJggg==",aspectRatio:1,src:"/static/6d91c86c0fde632ba4cd01062fd9ccfa/fbe2f/gatsby-astronaut.png",srcSet:"/static/6d91c86c0fde632ba4cd01062fd9ccfa/e1fed/gatsby-astronaut.png 75w,\n/static/6d91c86c0fde632ba4cd01062fd9ccfa/08283/gatsby-astronaut.png 150w,\n/static/6d91c86c0fde632ba4cd01062fd9ccfa/fbe2f/gatsby-astronaut.png 300w,\n/static/6d91c86c0fde632ba4cd01062fd9ccfa/59257/gatsby-astronaut.png 450w,\n/static/6d91c86c0fde632ba4cd01062fd9ccfa/26d9e/gatsby-astronaut.png 600w,\n/static/6d91c86c0fde632ba4cd01062fd9ccfa/a3fa0/gatsby-astronaut.png 800w",sizes:"(max-width: 300px) 100vw, 300px"}}}}}},166:function(t,e,a){"use strict";var i=a(8);e.__esModule=!0,e.default=void 0;var n,r=i(a(7)),s=i(a(35)),o=i(a(75)),c=i(a(76)),l=i(a(0)),d=i(a(4)),u=function(t){var e=(0,c.default)({},t);return e.resolutions&&(e.fixed=e.resolutions,delete e.resolutions),e.sizes&&(e.fluid=e.sizes,delete e.sizes),e},f=Object.create({}),p=function(t){var e=u(t),a=e.fluid?e.fluid.src:e.fixed.src;return f[a]||!1},h=new WeakMap;var m=function(t,e){var a=(void 0===n&&"undefined"!=typeof window&&window.IntersectionObserver&&(n=new window.IntersectionObserver(function(t){t.forEach(function(t){if(h.has(t.target)){var e=h.get(t.target);(t.isIntersecting||t.intersectionRatio>0)&&(n.unobserve(t.target),h.delete(t.target),e())}})},{rootMargin:"200px"})),n);return a&&(a.observe(t),h.set(t,e)),function(){a.unobserve(t),h.delete(t)}},g=function(t){var e=t.src?'src="'+t.src+'" ':'src="" ',a=t.sizes?'sizes="'+t.sizes+'" ':"",i=t.srcSetWebp?"<source type='image/webp' srcset=\""+t.srcSetWebp+'" '+a+"/>":"",n=t.srcSet?'srcset="'+t.srcSet+'" ':"",r=t.title?'title="'+t.title+'" ':"",s=t.alt?'alt="'+t.alt+'" ':'alt="" ';return"<picture>"+i+"<img "+(t.width?'width="'+t.width+'" ':"")+(t.height?'height="'+t.height+'" ':"")+a+n+e+s+r+(t.crossOrigin?'crossorigin="'+t.crossOrigin+'" ':"")+'style="position:absolute;top:0;left:0;opacity:1;width:100%;height:100%;object-fit:cover;object-position:center"/></picture>'},y=l.default.forwardRef(function(t,e){var a=t.sizes,i=t.srcSet,n=t.src,r=t.style,s=t.onLoad,d=t.onError,u=(0,o.default)(t,["sizes","srcSet","src","style","onLoad","onError"]);return l.default.createElement("img",(0,c.default)({sizes:a,srcSet:i,src:n},u,{onLoad:s,onError:d,ref:e,style:(0,c.default)({position:"absolute",top:0,left:0,width:"100%",height:"100%",objectFit:"cover",objectPosition:"center"},r)}))});y.propTypes={style:d.default.object,onError:d.default.func,onLoad:d.default.func};var b=function(t){function e(e){var a;a=t.call(this,e)||this;var i=!0,n=!1,r=e.fadeIn,o=p(e);!o&&"undefined"!=typeof window&&window.IntersectionObserver&&(i=!1,n=!0),"undefined"==typeof window&&(i=!1),e.critical&&(i=!0,n=!1);var c=!(e.critical&&!e.fadeIn);return a.state={isVisible:i,imgLoaded:!1,imgCached:!1,IOSupported:n,fadeIn:r,hasNoScript:c,seenBefore:o},a.imageRef=l.default.createRef(),a.handleImageLoaded=a.handleImageLoaded.bind((0,s.default)((0,s.default)(a))),a.handleRef=a.handleRef.bind((0,s.default)((0,s.default)(a))),a}(0,r.default)(e,t);var a=e.prototype;return a.componentDidMount=function(){if(this.state.isVisible&&"function"==typeof this.props.onStartLoad&&this.props.onStartLoad({wasCached:p(this.props)}),this.props.critical){var t=this.imageRef.current;t&&t.complete&&this.handleImageLoaded()}},a.componentWillUnmount=function(){this.cleanUpListeners&&this.cleanUpListeners()},a.handleRef=function(t){var e=this;this.state.IOSupported&&t&&(this.cleanUpListeners=m(t,function(){var t=p(e.props);e.state.isVisible||"function"!=typeof e.props.onStartLoad||e.props.onStartLoad({wasCached:t}),e.setState({isVisible:!0},function(){return e.setState({imgLoaded:t,imgCached:e.imageRef.current.currentSrc.length>0})})}))},a.handleImageLoaded=function(){var t,e,a;t=this.props,e=u(t),a=e.fluid?e.fluid.src:e.fixed.src,f[a]=!0,this.setState({imgLoaded:!0}),this.state.seenBefore&&this.setState({fadeIn:!1}),this.props.onLoad&&this.props.onLoad()},a.render=function(){var t=u(this.props),e=t.title,a=t.alt,i=t.className,n=t.style,r=void 0===n?{}:n,s=t.imgStyle,o=void 0===s?{}:s,d=t.placeholderStyle,f=void 0===d?{}:d,p=t.placeholderClassName,h=t.fluid,m=t.fixed,b=t.backgroundColor,v=t.Tag,w=t.itemProp,S=this.state.imgLoaded||!1===this.state.fadeIn,E=!0===this.state.fadeIn&&!this.state.imgCached,R=(0,c.default)({opacity:S?1:0,transition:E?"opacity 0.5s":"none"},o),z="boolean"==typeof b?"lightgray":b,A={transitionDelay:"0.5s"},C=(0,c.default)({opacity:this.state.imgLoaded?0:1},E&&A,o,f),L={title:e,alt:this.state.isVisible?"":a,style:C,className:p};if(h){var I=h;return l.default.createElement(v,{className:(i||"")+" gatsby-image-wrapper",style:(0,c.default)({position:"relative",overflow:"hidden"},r),ref:this.handleRef,key:"fluid-"+JSON.stringify(I.srcSet)},l.default.createElement(v,{style:{width:"100%",paddingBottom:100/I.aspectRatio+"%"}}),z&&l.default.createElement(v,{title:e,style:(0,c.default)({backgroundColor:z,position:"absolute",top:0,bottom:0,opacity:this.state.imgLoaded?0:1,right:0,left:0},E&&A)}),I.base64&&l.default.createElement(y,(0,c.default)({src:I.base64},L)),I.tracedSVG&&l.default.createElement(y,(0,c.default)({src:I.tracedSVG},L)),this.state.isVisible&&l.default.createElement("picture",null,I.srcSetWebp&&l.default.createElement("source",{type:"image/webp",srcSet:I.srcSetWebp,sizes:I.sizes}),l.default.createElement(y,{alt:a,title:e,sizes:I.sizes,src:I.src,crossOrigin:this.props.crossOrigin,srcSet:I.srcSet,style:R,ref:this.imageRef,onLoad:this.handleImageLoaded,onError:this.props.onError,itemProp:w})),this.state.hasNoScript&&l.default.createElement("noscript",{dangerouslySetInnerHTML:{__html:g((0,c.default)({alt:a,title:e},I))}}))}if(m){var T=m,N=(0,c.default)({position:"relative",overflow:"hidden",display:"inline-block",width:T.width,height:T.height},r);return"inherit"===r.display&&delete N.display,l.default.createElement(v,{className:(i||"")+" gatsby-image-wrapper",style:N,ref:this.handleRef,key:"fixed-"+JSON.stringify(T.srcSet)},z&&l.default.createElement(v,{title:e,style:(0,c.default)({backgroundColor:z,width:T.width,opacity:this.state.imgLoaded?0:1,height:T.height},E&&A)}),T.base64&&l.default.createElement(y,(0,c.default)({src:T.base64},L)),T.tracedSVG&&l.default.createElement(y,(0,c.default)({src:T.tracedSVG},L)),this.state.isVisible&&l.default.createElement("picture",null,T.srcSetWebp&&l.default.createElement("source",{type:"image/webp",srcSet:T.srcSetWebp,sizes:T.sizes}),l.default.createElement(y,{alt:a,title:e,width:T.width,height:T.height,sizes:T.sizes,src:T.src,crossOrigin:this.props.crossOrigin,srcSet:T.srcSet,style:R,ref:this.imageRef,onLoad:this.handleImageLoaded,onError:this.props.onError,itemProp:w})),this.state.hasNoScript&&l.default.createElement("noscript",{dangerouslySetInnerHTML:{__html:g((0,c.default)({alt:a,title:e},T))}}))}return null},e}(l.default.Component);b.defaultProps={critical:!1,fadeIn:!0,alt:"",Tag:"div"};var v=d.default.shape({width:d.default.number.isRequired,height:d.default.number.isRequired,src:d.default.string.isRequired,srcSet:d.default.string.isRequired,base64:d.default.string,tracedSVG:d.default.string,srcWebp:d.default.string,srcSetWebp:d.default.string}),w=d.default.shape({aspectRatio:d.default.number.isRequired,src:d.default.string.isRequired,srcSet:d.default.string.isRequired,sizes:d.default.string.isRequired,base64:d.default.string,tracedSVG:d.default.string,srcWebp:d.default.string,srcSetWebp:d.default.string});b.propTypes={resolutions:v,sizes:w,fixed:v,fluid:w,fadeIn:d.default.bool,title:d.default.string,alt:d.default.string,className:d.default.oneOfType([d.default.string,d.default.object]),critical:d.default.bool,crossOrigin:d.default.oneOfType([d.default.string,d.default.bool]),style:d.default.object,imgStyle:d.default.object,placeholderStyle:d.default.object,placeholderClassName:d.default.string,backgroundColor:d.default.oneOfType([d.default.string,d.default.bool]),onLoad:d.default.func,onError:d.default.func,onStartLoad:d.default.func,Tag:d.default.string,itemProp:d.default.string};var S=b;e.default=S},167:function(t,e,a){var i=a(25).f,n=Function.prototype,r=/^\s*function ([^ (]*)/;"name"in n||a(18)&&i(n,"name",{configurable:!0,get:function(){try{return(""+this).match(r)[1]}catch(t){return""}}})}}]);
//# sourceMappingURL=component---src-pages-index-js-edad0a6dd0d36ec7cdbd.js.map